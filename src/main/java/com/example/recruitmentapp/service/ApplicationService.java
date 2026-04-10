package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.ApplicationRequest;
import com.example.recruitmentapp.dto.ApplicationResponse;

import java.util.List;

public interface ApplicationService {
    ApplicationResponse create(ApplicationRequest request);

    ApplicationResponse getById(Integer id);

    List<ApplicationResponse> getAll();

    ApplicationResponse update(Integer id, ApplicationRequest request);

    void delete(Integer id);
}
