package com.example.recruitmentapp.controller;

import com.example.recruitmentapp.dto.ApplicationFileRequest;
import com.example.recruitmentapp.dto.ApplicationFileResponse;
import com.example.recruitmentapp.service.ApplicationFileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application-files")
@RequiredArgsConstructor
public class ApplicationFileController {

    private final ApplicationFileService service;

    @PostMapping
    public ResponseEntity<ApplicationFileResponse> create(@Valid @RequestBody ApplicationFileRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationFileResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ApplicationFileResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationFileResponse> update(@PathVariable Integer id, @Valid @RequestBody ApplicationFileRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
