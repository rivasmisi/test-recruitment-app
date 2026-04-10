package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.RecruitmentRequest;
import com.example.recruitmentapp.dto.RecruitmentResponse;
import com.example.recruitmentapp.entity.Profile;
import com.example.recruitmentapp.entity.Recruitment;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.RecruitmentMapper;
import com.example.recruitmentapp.repository.ProfileRepository;
import com.example.recruitmentapp.repository.RecruitmentRepository;
import com.example.recruitmentapp.service.RecruitmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentServiceImpl implements RecruitmentService {

    private final RecruitmentRepository repository;
    private final RecruitmentMapper mapper;
    private final ProfileRepository profileRepository;

    @Override
    public RecruitmentResponse create(RecruitmentRequest request) {
        Profile profile = profileRepository.findById(request.getProfileId())
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + request.getProfileId()));
        Recruitment entity = mapper.toEntity(request, profile);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public RecruitmentResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recruitment not found with id: " + id)));
    }

    @Override
    public List<RecruitmentResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public RecruitmentResponse update(Integer id, RecruitmentRequest request) {
        Recruitment existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recruitment not found with id: " + id));
        Profile profile = profileRepository.findById(request.getProfileId())
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + request.getProfileId()));
        mapper.updateEntity(existing, request, profile);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recruitment not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
