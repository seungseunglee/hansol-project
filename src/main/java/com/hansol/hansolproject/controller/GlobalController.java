package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Global;
import com.hansol.hansolproject.service.*;
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
    public ResponseEntity<?> getAll() {

        final List<Global> globals = globalService.getAll();

        return ResponseEntity.ok(globals);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getByEmployeeId(@PathVariable Long id) {

        final Global global = globalService.getByEmployeeId(id);

        return ResponseEntity.ok(global);
    }

    @PostMapping
    public ResponseEntity<?> createGlobal(@RequestBody Global request) {

        globalService.createGlobal(request.getWorkCode(), request.getWorkName(), request.getCompany(), request.getEmpName(), request.getPosition(), request.getTask(), request.getTelephone());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGlobal(@PathVariable Long id) {

        globalService.deleteGlobal(id);

        return ResponseEntity.noContent().build();
    }

}
