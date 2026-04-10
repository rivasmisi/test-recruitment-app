package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.RecruitmentStageRequest;
import com.example.recruitmentapp.dto.RecruitmentStageResponse;
import com.example.recruitmentapp.entity.ProfileStageTemplate;
import com.example.recruitmentapp.entity.Recruitment;
import com.example.recruitmentapp.entity.RecruitmentStage;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.RecruitmentStageMapper;
import com.example.recruitmentapp.repository.ProfileStageTemplateRepository;
import com.example.recruitmentapp.repository.RecruitmentRepository;
import com.example.recruitmentapp.repository.RecruitmentStageRepository;
import com.example.recruitmentapp.service.RecruitmentStageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentStageServiceImpl implements RecruitmentStageService {

    private final RecruitmentStageRepository repository;
    private final RecruitmentStageMapper mapper;
    private final RecruitmentRepository recruitmentRepository;
    private final ProfileStageTemplateRepository profileStageTemplateRepository;

    @Override
    public RecruitmentStageResponse create(RecruitmentStageRequest request) {
        Recruitment recruitment = recruitmentRepository.findById(request.getRecruitmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Recruitment not found with id: " + request.getRecruitmentId()));
        ProfileStageTemplate profileStageTemplate = request.getProfileStageTemplateId() == null ? null : profileStageTemplateRepository.findById(request.getProfileStageTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageTemplate not found with id: " + request.getProfileStageTemplateId()));
        RecruitmentStage entity = mapper.toEntity(request, recruitment, profileStageTemplate);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public RecruitmentStageResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStage not found with id: " + id)));
    }

    @Override
    public List<RecruitmentStageResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public RecruitmentStageResponse update(Integer id, RecruitmentStageRequest request) {
        RecruitmentStage existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStage not found with id: " + id));
        Recruitment recruitment = recruitmentRepository.findById(request.getRecruitmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Recruitment not found with id: " + request.getRecruitmentId()));
        ProfileStageTemplate profileStageTemplate = request.getProfileStageTemplateId() == null ? null : profileStageTemplateRepository.findById(request.getProfileStageTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("ProfileStageTemplate not found with id: " + request.getProfileStageTemplateId()));
        mapper.updateEntity(existing, request, recruitment, profileStageTemplate);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("RecruitmentStage not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
