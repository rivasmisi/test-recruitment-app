package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.ApplicationScoreRequest;
import com.example.recruitmentapp.dto.ApplicationScoreResponse;
import com.example.recruitmentapp.entity.Application;
import com.example.recruitmentapp.entity.ApplicationScore;
import com.example.recruitmentapp.entity.RecruitmentStageScoreTemplate;
import org.springframework.stereotype.Component;

@Component
public class ApplicationScoreMapper {

    public ApplicationScore toEntity(ApplicationScoreRequest request, Application application, RecruitmentStageScoreTemplate stageScoreTemplate) {
        ApplicationScore entity = new ApplicationScore();
        entity.setApplication(application);
        entity.setStageScoreTemplate(stageScoreTemplate);
        entity.setScore(request.getScore());
        entity.setComments(request.getComments());
        return entity;
    }

    public void updateEntity(ApplicationScore entity, ApplicationScoreRequest request, Application application, RecruitmentStageScoreTemplate stageScoreTemplate) {
        entity.setApplication(application);
        entity.setStageScoreTemplate(stageScoreTemplate);
        entity.setScore(request.getScore());
        entity.setComments(request.getComments());
    }

    public ApplicationScoreResponse toResponse(ApplicationScore entity) {
        return ApplicationScoreResponse.builder()
                .id(entity.getId())
                .applicationId(entity.getApplication() != null ? entity.getApplication().getId() : null)
                .stageScoreTemplateId(entity.getStageScoreTemplate() != null ? entity.getStageScoreTemplate().getId() : null)
                .score(entity.getScore())
                .comments(entity.getComments())
                .build();
    }
}
