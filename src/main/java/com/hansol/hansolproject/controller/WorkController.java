package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Work;
import com.hansol.hansolproject.service.WorkService;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "모든 업무 조회")
    public ResponseEntity<?> getAllWorks() {

        final List<Work> works = workService.getAllWorks();

        return ResponseEntity.ok(works);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id로 업무 조회")
    public ResponseEntity<?> getWorkById(@PathVariable Long id) {

        final Work work = workService.getWorkById(id);

        return ResponseEntity.ok(work);
    }

    @PostMapping
    @ApiOperation(value = "업무 생성")
    public ResponseEntity<?> createWork(@RequestBody WorkDto request) {

        final Long id = workService.createWork(request.getCode(), request.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "업무 수정")
    public ResponseEntity<?> updateWork(@PathVariable Long id, @RequestBody WorkDto request) {

        workService.updateWork(id, request.getCode(), request.getName());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "업무 삭제")
    public ResponseEntity<?> deleteWork(@PathVariable Long id) {

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
