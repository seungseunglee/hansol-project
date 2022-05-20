package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Employee;
import com.hansol.hansolproject.service.EmployeeService;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {

        final List<Employee> employees = employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {

        final Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee #" + id + " is not founded"));

        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto request) {


        final Long id = employeeService.createEmployee(request.getName(), request.getPosition(), request.getTask(), request.getTelephone(), request.getWorkId());

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto request) {

        final Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee #" + id + " is not founded"));

        employeeService.updateEmployee(employee, request.getName(), request.getPosition(), request.getTask(), request.getTelephone(), request.getWorkId());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {

        employeeService.getEmployeeById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee #" + id + " is not founded"));

        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }

    @Getter
    static class EmployeeDto {
        @NonNull
        private String name;
        @NonNull
        private String position;
        private String task;
        private String telephone;
        private Long workId;
    }

}
