package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.RecruitmentQuestionRequest;
import com.example.recruitmentapp.dto.RecruitmentQuestionResponse;
import com.example.recruitmentapp.entity.ProfileQuestionTemplate;
import com.example.recruitmentapp.entity.RecruitmentQuestion;
import com.example.recruitmentapp.entity.RecruitmentStage;
import org.springframework.stereotype.Component;

@Component
public class RecruitmentQuestionMapper {

    public RecruitmentQuestion toEntity(RecruitmentQuestionRequest request, RecruitmentStage recruitmentStage, ProfileQuestionTemplate profileQuestionTemplate) {
        RecruitmentQuestion entity = new RecruitmentQuestion();
        entity.setRecruitmentStage(recruitmentStage);
        entity.setProfileQuestionTemplate(profileQuestionTemplate);
        entity.setQuestion(request.getQuestion());
        entity.setDisplayOrder(request.getDisplayOrder());
        entity.setQuestionType(request.getQuestionType());
        entity.setIsRequired(request.getIsRequired());
        return entity;
    }

    public void updateEntity(RecruitmentQuestion entity, RecruitmentQuestionRequest request, RecruitmentStage recruitmentStage, ProfileQuestionTemplate profileQuestionTemplate) {
        entity.setRecruitmentStage(recruitmentStage);
        entity.setProfileQuestionTemplate(profileQuestionTemplate);
        entity.setQuestion(request.getQuestion());
        entity.setDisplayOrder(request.getDisplayOrder());
        entity.setQuestionType(request.getQuestionType());
        entity.setIsRequired(request.getIsRequired());
    }

    public RecruitmentQuestionResponse toResponse(RecruitmentQuestion entity) {
        return RecruitmentQuestionResponse.builder()
                .id(entity.getId())
                .recruitmentStageId(entity.getRecruitmentStage() != null ? entity.getRecruitmentStage().getId() : null)
                .profileQuestionTemplateId(entity.getProfileQuestionTemplate() != null ? entity.getProfileQuestionTemplate().getId() : null)
                .question(entity.getQuestion())
                .displayOrder(entity.getDisplayOrder())
                .questionType(entity.getQuestionType())
                .isRequired(entity.getIsRequired())
                .build();
    }
}
