package com.example.recruitmentapp.controller;

import com.example.recruitmentapp.dto.ProfileStageScoreTemplateRequest;
import com.example.recruitmentapp.dto.ProfileStageScoreTemplateResponse;
import com.example.recruitmentapp.service.ProfileStageScoreTemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile-stage-score-templates")
@RequiredArgsConstructor
public class ProfileStageScoreTemplateController {

    private final ProfileStageScoreTemplateService service;

    @PostMapping
    public ResponseEntity<ProfileStageScoreTemplateResponse> create(@Valid @RequestBody ProfileStageScoreTemplateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileStageScoreTemplateResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfileStageScoreTemplateResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileStageScoreTemplateResponse> update(@PathVariable Integer id, @Valid @RequestBody ProfileStageScoreTemplateRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
