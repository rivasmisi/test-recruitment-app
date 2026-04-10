package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.RecruitmentQuestionRequest;
import com.example.recruitmentapp.dto.RecruitmentQuestionResponse;
import com.example.recruitmentapp.entity.ProfileQuestionTemplate;
import com.example.recruitmentapp.entity.RecruitmentQuestion;
import com.example.recruitmentapp.entity.RecruitmentStage;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.RecruitmentQuestionMapper;
import com.example.recruitmentapp.repository.ProfileQuestionTemplateRepository;
import com.example.recruitmentapp.repository.RecruitmentQuestionRepository;
import com.example.recruitmentapp.repository.RecruitmentStageRepository;
import com.example.recruitmentapp.service.RecruitmentQuestionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentQuestionServiceImpl implements RecruitmentQuestionService {

    private final RecruitmentQuestionRepository repository;
    private final RecruitmentQuestionMapper mapper;
    private final RecruitmentStageRepository recruitmentStageRepository;
    private final ProfileQuestionTemplateRepository profileQuestionTemplateRepository;

    @Override
    public RecruitmentQuestionResponse create(RecruitmentQuestionRequest request) {
        RecruitmentStage recruitmentStage = recruitmentStageRepository.findById(request.getRecruitmentStageId())
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStage not found with id: " + request.getRecruitmentStageId()));
        ProfileQuestionTemplate profileQuestionTemplate = request.getProfileQuestionTemplateId() == null ? null : profileQuestionTemplateRepository.findById(request.getProfileQuestionTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("ProfileQuestionTemplate not found with id: " + request.getProfileQuestionTemplateId()));
        RecruitmentQuestion entity = mapper.toEntity(request, recruitmentStage, profileQuestionTemplate);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public RecruitmentQuestionResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentQuestion not found with id: " + id)));
    }

    @Override
    public List<RecruitmentQuestionResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public RecruitmentQuestionResponse update(Integer id, RecruitmentQuestionRequest request) {
        RecruitmentQuestion existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentQuestion not found with id: " + id));
        RecruitmentStage recruitmentStage = recruitmentStageRepository.findById(request.getRecruitmentStageId())
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStage not found with id: " + request.getRecruitmentStageId()));
        ProfileQuestionTemplate profileQuestionTemplate = request.getProfileQuestionTemplateId() == null ? null : profileQuestionTemplateRepository.findById(request.getProfileQuestionTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("ProfileQuestionTemplate not found with id: " + request.getProfileQuestionTemplateId()));
        mapper.updateEntity(existing, request, recruitmentStage, profileQuestionTemplate);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("RecruitmentQuestion not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
