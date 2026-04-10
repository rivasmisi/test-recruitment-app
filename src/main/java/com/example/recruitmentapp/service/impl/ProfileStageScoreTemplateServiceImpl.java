package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.ProfileStageScoreTemplateRequest;
import com.example.recruitmentapp.dto.ProfileStageScoreTemplateResponse;
import com.example.recruitmentapp.entity.ProfileStageScoreTemplate;
import com.example.recruitmentapp.entity.ProfileStageTemplate;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.ProfileStageScoreTemplateMapper;
import com.example.recruitmentapp.repository.ProfileStageScoreTemplateRepository;
import com.example.recruitmentapp.repository.ProfileStageTemplateRepository;
import com.example.recruitmentapp.service.ProfileStageScoreTemplateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileStageScoreTemplateServiceImpl implements ProfileStageScoreTemplateService {

    private final ProfileStageScoreTemplateRepository repository;
    private final ProfileStageScoreTemplateMapper mapper;
    private final ProfileStageTemplateRepository profileStageTemplateRepository;

    @Override
    public ProfileStageScoreTemplateResponse create(ProfileStageScoreTemplateRequest request) {
        ProfileStageTemplate profileStageTemplate = profileStageTemplateRepository.findById(request.getProfileStageTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageTemplate not found with id: " + request.getProfileStageTemplateId()));
        ProfileStageScoreTemplate entity = mapper.toEntity(request, profileStageTemplate);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public ProfileStageScoreTemplateResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageScoreTemplate not found with id: " + id)));
    }

    @Override
    public List<ProfileStageScoreTemplateResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public ProfileStageScoreTemplateResponse update(Integer id, ProfileStageScoreTemplateRequest request) {
        ProfileStageScoreTemplate existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageScoreTemplate not found with id: " + id));
        ProfileStageTemplate profileStageTemplate = profileStageTemplateRepository.findById(request.getProfileStageTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageTemplate not found with id: " + request.getProfileStageTemplateId()));
        mapper.updateEntity(existing, request, profileStageTemplate);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ProfileStageScoreTemplate not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
