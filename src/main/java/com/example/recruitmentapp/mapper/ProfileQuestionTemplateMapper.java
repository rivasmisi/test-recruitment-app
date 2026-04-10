package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.ProfileQuestionTemplateRequest;
import com.example.recruitmentapp.dto.ProfileQuestionTemplateResponse;
import com.example.recruitmentapp.entity.ProfileQuestionTemplate;
import com.example.recruitmentapp.entity.ProfileStageTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProfileQuestionTemplateMapper {

    public ProfileQuestionTemplate toEntity(ProfileQuestionTemplateRequest request, ProfileStageTemplate profileStageTemplate) {
        ProfileQuestionTemplate entity = new ProfileQuestionTemplate();
        entity.setProfileStageTemplate(profileStageTemplate);
        entity.setQuestion(request.getQuestion());
        entity.setDisplayOrder(request.getDisplayOrder());
        entity.setQuestionType(request.getQuestionType());
        entity.setIsRequired(request.getIsRequired());
        return entity;
    }

    public void updateEntity(ProfileQuestionTemplate entity, ProfileQuestionTemplateRequest request, ProfileStageTemplate profileStageTemplate) {
        entity.setProfileStageTemplate(profileStageTemplate);
        entity.setQuestion(request.getQuestion());
        entity.setDisplayOrder(request.getDisplayOrder());
        entity.setQuestionType(request.getQuestionType());
        entity.setIsRequired(request.getIsRequired());
    }

    public ProfileQuestionTemplateResponse toResponse(ProfileQuestionTemplate entity) {
        return ProfileQuestionTemplateResponse.builder()
                .id(entity.getId())
                .profileStageTemplateId(entity.getProfileStageTemplate() != null ? entity.getProfileStageTemplate().getId() : null)
                .question(entity.getQuestion())
                .displayOrder(entity.getDisplayOrder())
                .questionType(entity.getQuestionType())
                .isRequired(entity.getIsRequired())
                .build();
    }
}
