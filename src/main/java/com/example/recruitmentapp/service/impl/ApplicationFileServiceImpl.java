package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.ApplicationFileRequest;
import com.example.recruitmentapp.dto.ApplicationFileResponse;
import com.example.recruitmentapp.entity.Application;
import com.example.recruitmentapp.entity.ApplicationFile;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.ApplicationFileMapper;
import com.example.recruitmentapp.repository.ApplicationFileRepository;
import com.example.recruitmentapp.repository.ApplicationRepository;
import com.example.recruitmentapp.service.ApplicationFileService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationFileServiceImpl implements ApplicationFileService {

    private final ApplicationFileRepository repository;
    private final ApplicationFileMapper mapper;
    private final ApplicationRepository applicationRepository;

    @Override
    public ApplicationFileResponse create(ApplicationFileRequest request) {
        Application application = applicationRepository.findById(request.getApplicationId())
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + request.getApplicationId()));
        ApplicationFile entity = mapper.toEntity(request, application);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public ApplicationFileResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApplicationFile not found with id: " + id)));
    }

    @Override
    public List<ApplicationFileResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public ApplicationFileResponse update(Integer id, ApplicationFileRequest request) {
        ApplicationFile existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApplicationFile not found with id: " + id));
        Application application = applicationRepository.findById(request.getApplicationId())
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + request.getApplicationId()));
        mapper.updateEntity(existing, request, application);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ApplicationFile not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
