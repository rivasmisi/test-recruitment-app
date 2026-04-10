package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.RecruitmentQuestionRequest;
import com.example.recruitmentapp.dto.RecruitmentQuestionResponse;

import java.util.List;

public interface RecruitmentQuestionService {
    RecruitmentQuestionResponse create(RecruitmentQuestionRequest request);

    RecruitmentQuestionResponse getById(Integer id);

    List<RecruitmentQuestionResponse> getAll();

    RecruitmentQuestionResponse update(Integer id, RecruitmentQuestionRequest request);

    void delete(Integer id);
}
