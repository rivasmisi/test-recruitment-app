package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.ProfileQuestionTemplateRequest;
import com.example.recruitmentapp.dto.ProfileQuestionTemplateResponse;
import com.example.recruitmentapp.entity.ProfileQuestionTemplate;
import com.example.recruitmentapp.entity.ProfileStageTemplate;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.ProfileQuestionTemplateMapper;
import com.example.recruitmentapp.repository.ProfileQuestionTemplateRepository;
import com.example.recruitmentapp.repository.ProfileStageTemplateRepository;
import com.example.recruitmentapp.service.ProfileQuestionTemplateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileQuestionTemplateServiceImpl implements ProfileQuestionTemplateService {

    private final ProfileQuestionTemplateRepository repository;
    private final ProfileQuestionTemplateMapper mapper;
    private final ProfileStageTemplateRepository profileStageTemplateRepository;

    @Override
    public ProfileQuestionTemplateResponse create(ProfileQuestionTemplateRequest request) {
        ProfileStageTemplate profileStageTemplate = profileStageTemplateRepository.findById(request.getProfileStageTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageTemplate not found with id: " + request.getProfileStageTemplateId()));
        ProfileQuestionTemplate entity = mapper.toEntity(request, profileStageTemplate);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public ProfileQuestionTemplateResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileQuestionTemplate not found with id: " + id)));
    }

    @Override
    public List<ProfileQuestionTemplateResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public ProfileQuestionTemplateResponse update(Integer id, ProfileQuestionTemplateRequest request) {
        ProfileQuestionTemplate existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProfileQuestionTemplate not found with id: " + id));
        ProfileStageTemplate profileStageTemplate = profileStageTemplateRepository.findById(request.getProfileStageTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageTemplate not found with id: " + request.getProfileStageTemplateId()));
        mapper.updateEntity(existing, request, profileStageTemplate);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ProfileQuestionTemplate not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
