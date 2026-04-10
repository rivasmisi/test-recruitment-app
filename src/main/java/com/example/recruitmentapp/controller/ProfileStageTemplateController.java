package com.example.recruitmentapp.controller;

import com.example.recruitmentapp.dto.ProfileStageTemplateRequest;
import com.example.recruitmentapp.dto.ProfileStageTemplateResponse;
import com.example.recruitmentapp.service.ProfileStageTemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile-stage-templates")
@RequiredArgsConstructor
public class ProfileStageTemplateController {

    private final ProfileStageTemplateService service;

    @PostMapping
    public ResponseEntity<ProfileStageTemplateResponse> create(@Valid @RequestBody ProfileStageTemplateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileStageTemplateResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfileStageTemplateResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileStageTemplateResponse> update(@PathVariable Integer id, @Valid @RequestBody ProfileStageTemplateRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
