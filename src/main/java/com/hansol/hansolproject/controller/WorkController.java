package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Work;
import com.hansol.hansolproject.service.WorkService;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/works")
public class WorkController {
    
    private final WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping
    public ResponseEntity<?> getAllWorks() {

        final List<Work> works = workService.getAllWorks();

        return ResponseEntity.ok(works);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkById(@PathVariable Long id) {

        final Work work = workService.getWorkById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " not founded"));

        return ResponseEntity.ok(work);
    }

    @PostMapping
    public ResponseEntity<?> createWork(@RequestBody WorkDto request) {

        final Long id = workService.createWork(request.getCode(), request.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateWork(@PathVariable Long id, @RequestBody WorkDto request) {

        final Work work = workService.getWorkById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " not founded"));

        workService.updateWork(work, request.getCode(), request.getName());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWork(@PathVariable Long id) {

        workService.getWorkById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " not founded"));

        workService.deleteWork(id);

        return ResponseEntity.noContent().build();
    }

    @Getter
    static class WorkDto {
        @NonNull
        private String code;
        @NonNull
        private String name;

    }
}
