package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Employee;
import com.hansol.hansolproject.service.EmployeeService;
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
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ApiOperation(value = "모든 사원 조회")
    public ResponseEntity<?> getAllEmployees() {

        final List<Employee> employees = employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id로 사원 조회")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {

        final Employee employee = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employee);
    }

    @PostMapping
    @ApiOperation(value = "사원 생성")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto request) {

        final Long id = employeeService.createEmployee(request.getName(), request.getPosition(), request.getTask(), request.getTelephone(), request.getWorkId());

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "사원 수정")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto request) {

        employeeService.updateEmployee(id, request.getName(), request.getPosition(), request.getTask(), request.getTelephone(), request.getWorkId());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "사원 삭제")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {

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
