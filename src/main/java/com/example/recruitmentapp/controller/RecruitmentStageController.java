package com.example.recruitmentapp.controller;

import com.example.recruitmentapp.dto.RecruitmentStageRequest;
import com.example.recruitmentapp.dto.RecruitmentStageResponse;
import com.example.recruitmentapp.service.RecruitmentStageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment-stages")
@RequiredArgsConstructor
public class RecruitmentStageController {

    private final RecruitmentStageService service;

    @PostMapping
    public ResponseEntity<RecruitmentStageResponse> create(@Valid @RequestBody RecruitmentStageRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruitmentStageResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RecruitmentStageResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecruitmentStageResponse> update(@PathVariable Integer id, @Valid @RequestBody RecruitmentStageRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
