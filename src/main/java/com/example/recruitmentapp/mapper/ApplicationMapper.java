package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.ApplicationRequest;
import com.example.recruitmentapp.dto.ApplicationResponse;
import com.example.recruitmentapp.entity.Application;
import com.example.recruitmentapp.entity.Recruitment;
import com.example.recruitmentapp.entity.RecruitmentStage;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {

    public Application toEntity(ApplicationRequest request, Recruitment recruitment, RecruitmentStage currentStage) {
        Application entity = new Application();
        entity.setRecruitment(recruitment);
        entity.setCurrentStage(currentStage);
        entity.setFullName(request.getFullName());
        entity.setEmail(request.getEmail());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setApplicationDate(request.getApplicationDate());
        entity.setStatus(request.getStatus());
        entity.setPreliminaryScore(request.getPreliminaryScore());
        entity.setGlobalScore(request.getGlobalScore());
        entity.setApplicationDurationDays(request.getApplicationDurationDays());
        return entity;
    }

    public void updateEntity(Application entity, ApplicationRequest request, Recruitment recruitment, RecruitmentStage currentStage) {
        entity.setRecruitment(recruitment);
        entity.setCurrentStage(currentStage);
        entity.setFullName(request.getFullName());
        entity.setEmail(request.getEmail());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setApplicationDate(request.getApplicationDate());
        entity.setStatus(request.getStatus());
        entity.setPreliminaryScore(request.getPreliminaryScore());
        entity.setGlobalScore(request.getGlobalScore());
        entity.setApplicationDurationDays(request.getApplicationDurationDays());
    }

    public ApplicationResponse toResponse(Application entity) {
        return ApplicationResponse.builder()
                .id(entity.getId())
                .recruitmentId(entity.getRecruitment() != null ? entity.getRecruitment().getId() : null)
                .currentStageId(entity.getCurrentStage() != null ? entity.getCurrentStage().getId() : null)
                .fullName(entity.getFullName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .applicationDate(entity.getApplicationDate())
                .status(entity.getStatus())
                .preliminaryScore(entity.getPreliminaryScore())
                .globalScore(entity.getGlobalScore())
                .applicationDurationDays(entity.getApplicationDurationDays())
                .build();
    }
}
