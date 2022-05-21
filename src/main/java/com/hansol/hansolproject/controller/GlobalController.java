package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Global;
import com.hansol.hansolproject.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class GlobalController {

    private final GlobalService globalService;

    @Autowired
    public GlobalController(GlobalService globalService) {
        this.globalService = globalService;
    }

    @GetMapping
    @ApiOperation(value = "모든 전체 필드 조회")
    public ResponseEntity<?> getAll() {

        final List<Global> globals = globalService.getAll();

        return ResponseEntity.ok(globals);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "사번으로 전체 필드 조회")
    public ResponseEntity<?> getByEmployeeId(@PathVariable Long id) {

        final Global global = globalService.getByEmployeeId(id);

        return ResponseEntity.ok(global);
    }

    @PostMapping
    @ApiOperation(value = "전체 필드 생성")
    public ResponseEntity<?> createGlobal(@RequestBody Global request) {

        globalService.createGlobal(request.getWorkCode(), request.getWorkName(), request.getCompany(), request.getEmpName(), request.getPosition(), request.getTask(), request.getTelephone());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "전체 필드 수정")
    public ResponseEntity<?> updateGlobal(@PathVariable Long id, @RequestBody Global request) {

        globalService.updateGlobal(id, request.getWorkCode(), request.getWorkName(), request.getCompany(), request.getEmpName(), request.getPosition(), request.getTask(), request.getTelephone());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "전체 필드 삭제")
    public ResponseEntity<?> deleteGlobal(@PathVariable Long id) {

        globalService.deleteGlobal(id);

        return ResponseEntity.noContent().build();
    }

}
