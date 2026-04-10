package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.ApplicationScoreRequest;
import com.example.recruitmentapp.dto.ApplicationScoreResponse;
import com.example.recruitmentapp.entity.Application;
import com.example.recruitmentapp.entity.ApplicationScore;
import com.example.recruitmentapp.entity.RecruitmentStageScoreTemplate;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.ApplicationScoreMapper;
import com.example.recruitmentapp.repository.ApplicationRepository;
import com.example.recruitmentapp.repository.ApplicationScoreRepository;
import com.example.recruitmentapp.repository.RecruitmentStageScoreTemplateRepository;
import com.example.recruitmentapp.service.ApplicationScoreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationScoreServiceImpl implements ApplicationScoreService {

    private final ApplicationScoreRepository repository;
    private final ApplicationScoreMapper mapper;
    private final ApplicationRepository applicationRepository;
    private final RecruitmentStageScoreTemplateRepository recruitmentStageScoreTemplateRepository;

    @Override
    public ApplicationScoreResponse create(ApplicationScoreRequest request) {
        Application application = applicationRepository.findById(request.getApplicationId())
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + request.getApplicationId()));
        RecruitmentStageScoreTemplate stageScoreTemplate = recruitmentStageScoreTemplateRepository.findById(request.getStageScoreTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStageScoreTemplate not found with id: " + request.getStageScoreTemplateId()));
        ApplicationScore entity = mapper.toEntity(request, application, stageScoreTemplate);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public ApplicationScoreResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApplicationScore not found with id: " + id)));
    }

    @Override
    public List<ApplicationScoreResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public ApplicationScoreResponse update(Integer id, ApplicationScoreRequest request) {
        ApplicationScore existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApplicationScore not found with id: " + id));
        Application application = applicationRepository.findById(request.getApplicationId())
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + request.getApplicationId()));
        RecruitmentStageScoreTemplate stageScoreTemplate = recruitmentStageScoreTemplateRepository.findById(request.getStageScoreTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStageScoreTemplate not found with id: " + request.getStageScoreTemplateId()));
        mapper.updateEntity(existing, request, application, stageScoreTemplate);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ApplicationScore not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
