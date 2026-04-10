package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.RecruitmentStageScoreTemplateRequest;
import com.example.recruitmentapp.dto.RecruitmentStageScoreTemplateResponse;
import com.example.recruitmentapp.entity.ProfileStageScoreTemplate;
import com.example.recruitmentapp.entity.RecruitmentStage;
import com.example.recruitmentapp.entity.RecruitmentStageScoreTemplate;
import org.springframework.stereotype.Component;

@Component
public class RecruitmentStageScoreTemplateMapper {

    public RecruitmentStageScoreTemplate toEntity(RecruitmentStageScoreTemplateRequest request, RecruitmentStage stage, ProfileStageScoreTemplate profileStageScoreTemplate) {
        RecruitmentStageScoreTemplate entity = new RecruitmentStageScoreTemplate();
        entity.setStage(stage);
        entity.setProfileStageScoreTemplate(profileStageScoreTemplate);
        entity.setLabel(request.getLabel());
        entity.setWeight(request.getWeight());
        entity.setDisplayOrder(request.getDisplayOrder());
        return entity;
    }

    public void updateEntity(RecruitmentStageScoreTemplate entity, RecruitmentStageScoreTemplateRequest request, RecruitmentStage stage, ProfileStageScoreTemplate profileStageScoreTemplate) {
        entity.setStage(stage);
        entity.setProfileStageScoreTemplate(profileStageScoreTemplate);
        entity.setLabel(request.getLabel());
        entity.setWeight(request.getWeight());
        entity.setDisplayOrder(request.getDisplayOrder());
    }

    public RecruitmentStageScoreTemplateResponse toResponse(RecruitmentStageScoreTemplate entity) {
        return RecruitmentStageScoreTemplateResponse.builder()
                .id(entity.getId())
                .stageId(entity.getStage() != null ? entity.getStage().getId() : null)
                .profileStageScoreTemplateId(entity.getProfileStageScoreTemplate() != null ? entity.getProfileStageScoreTemplate().getId() : null)
                .label(entity.getLabel())
                .weight(entity.getWeight())
                .displayOrder(entity.getDisplayOrder())
                .build();
    }
}
