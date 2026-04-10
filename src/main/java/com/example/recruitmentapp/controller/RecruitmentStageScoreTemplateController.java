package com.example.recruitmentapp.controller;

import com.example.recruitmentapp.dto.RecruitmentStageScoreTemplateRequest;
import com.example.recruitmentapp.dto.RecruitmentStageScoreTemplateResponse;
import com.example.recruitmentapp.service.RecruitmentStageScoreTemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment-stage-score-templates")
@RequiredArgsConstructor
public class RecruitmentStageScoreTemplateController {

    private final RecruitmentStageScoreTemplateService service;

    @PostMapping
    public ResponseEntity<RecruitmentStageScoreTemplateResponse> create(@Valid @RequestBody RecruitmentStageScoreTemplateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruitmentStageScoreTemplateResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RecruitmentStageScoreTemplateResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecruitmentStageScoreTemplateResponse> update(@PathVariable Integer id, @Valid @RequestBody RecruitmentStageScoreTemplateRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
