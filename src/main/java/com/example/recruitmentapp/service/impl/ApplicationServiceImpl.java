package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.ApplicationRequest;
import com.example.recruitmentapp.dto.ApplicationResponse;
import com.example.recruitmentapp.entity.Application;
import com.example.recruitmentapp.entity.Recruitment;
import com.example.recruitmentapp.entity.RecruitmentStage;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.ApplicationMapper;
import com.example.recruitmentapp.repository.ApplicationRepository;
import com.example.recruitmentapp.repository.RecruitmentRepository;
import com.example.recruitmentapp.repository.RecruitmentStageRepository;
import com.example.recruitmentapp.service.ApplicationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository repository;
    private final ApplicationMapper mapper;
    private final RecruitmentRepository recruitmentRepository;
    private final RecruitmentStageRepository recruitmentStageRepository;

    @Override
    public ApplicationResponse create(ApplicationRequest request) {
        Recruitment recruitment = recruitmentRepository.findById(request.getRecruitmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Recruitment not found with id: " + request.getRecruitmentId()));
        RecruitmentStage currentStage = request.getCurrentStageId() == null ? null : recruitmentStageRepository.findById(request.getCurrentStageId())
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStage not found with id: " + request.getCurrentStageId()));
        Application entity = mapper.toEntity(request, recruitment, currentStage);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public ApplicationResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id)));
    }

    @Override
    public List<ApplicationResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public ApplicationResponse update(Integer id, ApplicationRequest request) {
        Application existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
        Recruitment recruitment = recruitmentRepository.findById(request.getRecruitmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Recruitment not found with id: " + request.getRecruitmentId()));
        RecruitmentStage currentStage = request.getCurrentStageId() == null ? null : recruitmentStageRepository.findById(request.getCurrentStageId())
                .orElseThrow(() -> new ResourceNotFoundException("RecruitmentStage not found with id: " + request.getCurrentStageId()));
        mapper.updateEntity(existing, request, recruitment, currentStage);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Application not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
