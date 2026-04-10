package com.example.recruitmentapp.service;

import com.example.recruitmentapp.dto.ApplicationFileRequest;
import com.example.recruitmentapp.dto.ApplicationFileResponse;

import java.util.List;

public interface ApplicationFileService {
    ApplicationFileResponse create(ApplicationFileRequest request);

    ApplicationFileResponse getById(Integer id);

    List<ApplicationFileResponse> getAll();

    ApplicationFileResponse update(Integer id, ApplicationFileRequest request);

    void delete(Integer id);
}
