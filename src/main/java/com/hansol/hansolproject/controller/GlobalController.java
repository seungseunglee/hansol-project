package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Global;
import com.hansol.hansolproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
