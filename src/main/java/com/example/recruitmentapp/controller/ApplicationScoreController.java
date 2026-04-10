package com.example.recruitmentapp.controller;

import com.example.recruitmentapp.dto.ApplicationScoreRequest;
import com.example.recruitmentapp.dto.ApplicationScoreResponse;
import com.example.recruitmentapp.service.ApplicationScoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application-scores")
@RequiredArgsConstructor
public class ApplicationScoreController {

    private final ApplicationScoreService service;

    @PostMapping
    public ResponseEntity<ApplicationScoreResponse> create(@Valid @RequestBody ApplicationScoreRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationScoreResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ApplicationScoreResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationScoreResponse> update(@PathVariable Integer id, @Valid @RequestBody ApplicationScoreRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
