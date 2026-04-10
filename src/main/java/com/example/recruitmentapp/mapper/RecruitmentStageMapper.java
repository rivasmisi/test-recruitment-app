package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.RecruitmentStageRequest;
import com.example.recruitmentapp.dto.RecruitmentStageResponse;
import com.example.recruitmentapp.entity.ProfileStageTemplate;
import com.example.recruitmentapp.entity.Recruitment;
import com.example.recruitmentapp.entity.RecruitmentStage;
import org.springframework.stereotype.Component;

@Component
public class RecruitmentStageMapper {

    public RecruitmentStage toEntity(RecruitmentStageRequest request, Recruitment recruitment, ProfileStageTemplate profileStageTemplate) {
        RecruitmentStage entity = new RecruitmentStage();
        entity.setRecruitment(recruitment);
        entity.setProfileStageTemplate(profileStageTemplate);
        entity.setDisplayOrder(request.getDisplayOrder());
        entity.setName(request.getName());
        return entity;
    }

    public void updateEntity(RecruitmentStage entity, RecruitmentStageRequest request, Recruitment recruitment, ProfileStageTemplate profileStageTemplate) {
        entity.setRecruitment(recruitment);
        entity.setProfileStageTemplate(profileStageTemplate);
        entity.setDisplayOrder(request.getDisplayOrder());
        entity.setName(request.getName());
    }

    public RecruitmentStageResponse toResponse(RecruitmentStage entity) {
        return RecruitmentStageResponse.builder()
                .id(entity.getId())
                .recruitmentId(entity.getRecruitment() != null ? entity.getRecruitment().getId() : null)
                .profileStageTemplateId(entity.getProfileStageTemplate() != null ? entity.getProfileStageTemplate().getId() : null)
                .displayOrder(entity.getDisplayOrder())
                .name(entity.getName())
                .build();
    }
}
