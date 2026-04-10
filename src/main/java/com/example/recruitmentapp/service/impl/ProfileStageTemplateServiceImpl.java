package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.ProfileStageTemplateRequest;
import com.example.recruitmentapp.dto.ProfileStageTemplateResponse;
import com.example.recruitmentapp.entity.Profile;
import com.example.recruitmentapp.entity.ProfileStageTemplate;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.ProfileStageTemplateMapper;
import com.example.recruitmentapp.repository.ProfileRepository;
import com.example.recruitmentapp.repository.ProfileStageTemplateRepository;
import com.example.recruitmentapp.service.ProfileStageTemplateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileStageTemplateServiceImpl implements ProfileStageTemplateService {

    private final ProfileStageTemplateRepository repository;
    private final ProfileStageTemplateMapper mapper;
    private final ProfileRepository profileRepository;

    @Override
    public ProfileStageTemplateResponse create(ProfileStageTemplateRequest request) {
        Profile profile = profileRepository.findById(request.getProfileId())
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + request.getProfileId()));
        ProfileStageTemplate entity = mapper.toEntity(request, profile);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public ProfileStageTemplateResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageTemplate not found with id: " + id)));
    }

    @Override
    public List<ProfileStageTemplateResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public ProfileStageTemplateResponse update(Integer id, ProfileStageTemplateRequest request) {
        ProfileStageTemplate existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageTemplate not found with id: " + id));
        Profile profile = profileRepository.findById(request.getProfileId())
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + request.getProfileId()));
        mapper.updateEntity(existing, request, profile);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ProfileStageTemplate not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
