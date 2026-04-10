package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.RecruitmentStageRequest;
import com.example.recruitmentapp.dto.RecruitmentStageResponse;

import java.util.List;

public interface RecruitmentStageService {
    RecruitmentStageResponse create(RecruitmentStageRequest request);

    RecruitmentStageResponse getById(Integer id);

    List<RecruitmentStageResponse> getAll();

    RecruitmentStageResponse update(Integer id, RecruitmentStageRequest request);

    void delete(Integer id);
}
