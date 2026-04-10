package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.ApplicationScoreRequest;
import com.example.recruitmentapp.dto.ApplicationScoreResponse;

import java.util.List;

public interface ApplicationScoreService {
    ApplicationScoreResponse create(ApplicationScoreRequest request);

    ApplicationScoreResponse getById(Integer id);

    List<ApplicationScoreResponse> getAll();

    ApplicationScoreResponse update(Integer id, ApplicationScoreRequest request);

    void delete(Integer id);
}
