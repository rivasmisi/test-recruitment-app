package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.RecruitmentStageScoreTemplateRequest;
import com.example.recruitmentapp.dto.RecruitmentStageScoreTemplateResponse;
import com.example.recruitmentapp.entity.ProfileStageScoreTemplate;
import com.example.recruitmentapp.entity.RecruitmentStage;
import com.example.recruitmentapp.entity.RecruitmentStageScoreTemplate;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.RecruitmentStageScoreTemplateMapper;
import com.example.recruitmentapp.repository.ProfileStageScoreTemplateRepository;
import com.example.recruitmentapp.repository.RecruitmentStageRepository;
import com.example.recruitmentapp.repository.RecruitmentStageScoreTemplateRepository;
import com.example.recruitmentapp.service.RecruitmentStageScoreTemplateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentStageScoreTemplateServiceImpl implements RecruitmentStageScoreTemplateService {

    private final RecruitmentStageScoreTemplateRepository repository;
    private final RecruitmentStageScoreTemplateMapper mapper;
    private final RecruitmentStageRepository recruitmentStageRepository;
    private final ProfileStageScoreTemplateRepository profileStageScoreTemplateRepository;

    @Override
    public RecruitmentStageScoreTemplateResponse create(RecruitmentStageScoreTemplateRequest request) {
        RecruitmentStage stage = recruitmentStageRepository.findById(request.getStageId())
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStage not found with id: " + request.getStageId()));
        ProfileStageScoreTemplate profileStageScoreTemplate = request.getProfileStageScoreTemplateId() == null ? null : profileStageScoreTemplateRepository.findById(request.getProfileStageScoreTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageScoreTemplate not found with id: " + request.getProfileStageScoreTemplateId()));
        RecruitmentStageScoreTemplate entity = mapper.toEntity(request, stage, profileStageScoreTemplate);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public RecruitmentStageScoreTemplateResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStageScoreTemplate not found with id: " + id)));
    }

    @Override
    public List<RecruitmentStageScoreTemplateResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public RecruitmentStageScoreTemplateResponse update(Integer id, RecruitmentStageScoreTemplateRequest request) {
        RecruitmentStageScoreTemplate existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStageScoreTemplate not found with id: " + id));
        RecruitmentStage stage = recruitmentStageRepository.findById(request.getStageId())
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStage not found with id: " + request.getStageId()));
        ProfileStageScoreTemplate profileStageScoreTemplate = request.getProfileStageScoreTemplateId() == null ? null : profileStageScoreTemplateRepository.findById(request.getProfileStageScoreTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageScoreTemplate not found with id: " + request.getProfileStageScoreTemplateId()));
        mapper.updateEntity(existing, request, stage, profileStageScoreTemplate);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("RecruitmentStageScoreTemplate not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
