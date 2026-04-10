package com.example.recruitmentapp.controller;

import com.example.recruitmentapp.dto.RecruitmentQuestionRequest;
import com.example.recruitmentapp.dto.RecruitmentQuestionResponse;
import com.example.recruitmentapp.service.RecruitmentQuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment-questions")
@RequiredArgsConstructor
public class RecruitmentQuestionController {

    private final RecruitmentQuestionService service;

    @PostMapping
    public ResponseEntity<RecruitmentQuestionResponse> create(@Valid @RequestBody RecruitmentQuestionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruitmentQuestionResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RecruitmentQuestionResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecruitmentQuestionResponse> update(@PathVariable Integer id, @Valid @RequestBody RecruitmentQuestionRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
