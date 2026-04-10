package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.ProfileRequest;
import com.example.recruitmentapp.dto.ProfileResponse;
import com.example.recruitmentapp.entity.Profile;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.ProfileMapper;
import com.example.recruitmentapp.repository.ProfileRepository;
import com.example.recruitmentapp.service.ProfileService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;
    private final ProfileMapper mapper;

    @Override
    public ProfileResponse create(ProfileRequest request) {
        Profile entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public ProfileResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + id)));
    }

    @Override
    public List<ProfileResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public ProfileResponse update(Integer id, ProfileRequest request) {
        Profile existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + id));
        mapper.updateEntity(existing, request);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Profile not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
