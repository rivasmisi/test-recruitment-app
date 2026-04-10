package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.ProfileStageTemplateRequest;
import com.example.recruitmentapp.dto.ProfileStageTemplateResponse;

import java.util.List;

public interface ProfileStageTemplateService {
    ProfileStageTemplateResponse create(ProfileStageTemplateRequest request);

    ProfileStageTemplateResponse getById(Integer id);

    List<ProfileStageTemplateResponse> getAll();

    ProfileStageTemplateResponse update(Integer id, ProfileStageTemplateRequest request);

    void delete(Integer id);
}
