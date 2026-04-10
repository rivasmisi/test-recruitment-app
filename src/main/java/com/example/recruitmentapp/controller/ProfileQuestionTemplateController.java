package com.example.recruitmentapp.controller;

import com.example.recruitmentapp.dto.ProfileQuestionTemplateRequest;
import com.example.recruitmentapp.dto.ProfileQuestionTemplateResponse;
import com.example.recruitmentapp.service.ProfileQuestionTemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile-question-templates")
@RequiredArgsConstructor
public class ProfileQuestionTemplateController {

    private final ProfileQuestionTemplateService service;

    @PostMapping
    public ResponseEntity<ProfileQuestionTemplateResponse> create(@Valid @RequestBody ProfileQuestionTemplateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileQuestionTemplateResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfileQuestionTemplateResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileQuestionTemplateResponse> update(@PathVariable Integer id, @Valid @RequestBody ProfileQuestionTemplateRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
