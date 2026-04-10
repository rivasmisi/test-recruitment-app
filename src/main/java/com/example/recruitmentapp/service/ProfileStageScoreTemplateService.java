package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.ProfileStageScoreTemplateRequest;
import com.example.recruitmentapp.dto.ProfileStageScoreTemplateResponse;

import java.util.List;

public interface ProfileStageScoreTemplateService {
    ProfileStageScoreTemplateResponse create(ProfileStageScoreTemplateRequest request);

    ProfileStageScoreTemplateResponse getById(Integer id);

    List<ProfileStageScoreTemplateResponse> getAll();

    ProfileStageScoreTemplateResponse update(Integer id, ProfileStageScoreTemplateRequest request);

    void delete(Integer id);
}
