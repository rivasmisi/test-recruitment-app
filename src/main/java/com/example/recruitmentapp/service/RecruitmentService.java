package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.RecruitmentRequest;
import com.example.recruitmentapp.dto.RecruitmentResponse;
import com.example.recruitmentapp.dto.RecruitmentInitializationResponse;

import java.util.List;

public interface RecruitmentService {
    RecruitmentResponse create(RecruitmentRequest request);

    RecruitmentResponse getById(Integer id);

    List<RecruitmentResponse> getAll();

    RecruitmentResponse update(Integer id, RecruitmentRequest request);

    void delete(Integer id);

    RecruitmentInitializationResponse initializeFromProfileTemplates(Integer id);
}
