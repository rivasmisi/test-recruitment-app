package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.RecruitmentStageScoreTemplateRequest;
import com.example.recruitmentapp.dto.RecruitmentStageScoreTemplateResponse;

import java.util.List;

public interface RecruitmentStageScoreTemplateService {
    RecruitmentStageScoreTemplateResponse create(RecruitmentStageScoreTemplateRequest request);

    RecruitmentStageScoreTemplateResponse getById(Integer id);

    List<RecruitmentStageScoreTemplateResponse> getAll();

    RecruitmentStageScoreTemplateResponse update(Integer id, RecruitmentStageScoreTemplateRequest request);

    void delete(Integer id);
}
