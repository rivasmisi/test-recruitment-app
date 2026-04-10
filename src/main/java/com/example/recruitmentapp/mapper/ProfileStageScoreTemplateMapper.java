package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.ProfileStageScoreTemplateRequest;
import com.example.recruitmentapp.dto.ProfileStageScoreTemplateResponse;
import com.example.recruitmentapp.entity.ProfileStageScoreTemplate;
import com.example.recruitmentapp.entity.ProfileStageTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProfileStageScoreTemplateMapper {

    public ProfileStageScoreTemplate toEntity(ProfileStageScoreTemplateRequest request, ProfileStageTemplate profileStageTemplate) {
        ProfileStageScoreTemplate entity = new ProfileStageScoreTemplate();
        entity.setProfileStageTemplate(profileStageTemplate);
        entity.setLabel(request.getLabel());
        entity.setWeight(request.getWeight());
        entity.setDisplayOrder(request.getDisplayOrder());
        return entity;
    }

    public void updateEntity(ProfileStageScoreTemplate entity, ProfileStageScoreTemplateRequest request, ProfileStageTemplate profileStageTemplate) {
        entity.setProfileStageTemplate(profileStageTemplate);
        entity.setLabel(request.getLabel());
        entity.setWeight(request.getWeight());
        entity.setDisplayOrder(request.getDisplayOrder());
    }

    public ProfileStageScoreTemplateResponse toResponse(ProfileStageScoreTemplate entity) {
        return ProfileStageScoreTemplateResponse.builder()
                .id(entity.getId())
                .profileStageTemplateId(entity.getProfileStageTemplate() != null ? entity.getProfileStageTemplate().getId() : null)
                .label(entity.getLabel())
                .weight(entity.getWeight())
                .displayOrder(entity.getDisplayOrder())
                .build();
    }
}
