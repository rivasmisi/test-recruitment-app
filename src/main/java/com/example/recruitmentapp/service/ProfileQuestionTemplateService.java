package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.ProfileQuestionTemplateRequest;
import com.example.recruitmentapp.dto.ProfileQuestionTemplateResponse;

import java.util.List;

public interface ProfileQuestionTemplateService {
    ProfileQuestionTemplateResponse create(ProfileQuestionTemplateRequest request);

    ProfileQuestionTemplateResponse getById(Integer id);

    List<ProfileQuestionTemplateResponse> getAll();

    ProfileQuestionTemplateResponse update(Integer id, ProfileQuestionTemplateRequest request);

    void delete(Integer id);
}
