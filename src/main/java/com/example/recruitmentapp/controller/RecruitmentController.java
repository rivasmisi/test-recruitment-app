package com.example.recruitmentapp.controller;

import com.example.recruitmentapp.dto.RecruitmentInitializationResponse;
import com.example.recruitmentapp.dto.RecruitmentRequest;
import com.example.recruitmentapp.dto.RecruitmentResponse;
import com.example.recruitmentapp.service.RecruitmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitments")
@RequiredArgsConstructor
public class RecruitmentController {

    private final RecruitmentService service;

    @PostMapping
    public ResponseEntity<RecruitmentResponse> create(@Valid @RequestBody RecruitmentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruitmentResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RecruitmentResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecruitmentResponse> update(@PathVariable Integer id, @Valid @RequestBody RecruitmentRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/initialize-from-profile")
    public ResponseEntity<RecruitmentInitializationResponse> initializeFromProfile(@PathVariable Integer id) {
        return ResponseEntity.ok(service.initializeFromProfileTemplates(id));
    }
}
