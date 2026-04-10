package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.ApplicationFileRequest;
import com.example.recruitmentapp.dto.ApplicationFileResponse;
import com.example.recruitmentapp.entity.Application;
import com.example.recruitmentapp.entity.ApplicationFile;
import org.springframework.stereotype.Component;

@Component
public class ApplicationFileMapper {

    public ApplicationFile toEntity(ApplicationFileRequest request, Application application) {
        ApplicationFile entity = new ApplicationFile();
        entity.setApplication(application);
        entity.setFileType(request.getFileType());
        entity.setFileName(request.getFileName());
        entity.setFileUrl(request.getFileUrl());
        return entity;
    }

    public void updateEntity(ApplicationFile entity, ApplicationFileRequest request, Application application) {
        entity.setApplication(application);
        entity.setFileType(request.getFileType());
        entity.setFileName(request.getFileName());
        entity.setFileUrl(request.getFileUrl());
    }

    public ApplicationFileResponse toResponse(ApplicationFile entity) {
        return ApplicationFileResponse.builder()
                .id(entity.getId())
                .applicationId(entity.getApplication() != null ? entity.getApplication().getId() : null)
                .fileType(entity.getFileType())
                .fileName(entity.getFileName())
                .fileUrl(entity.getFileUrl())
                .build();
    }
}
