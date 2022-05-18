package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Employee;
import com.hansol.hansolproject.exception.NotFoundException;
import com.hansol.hansolproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Long createEmployee(@RequestBody Employee request) {
        return employeeService.createEmployee(request);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployeeById();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Long updateEmployee(@PathVariable Long id, @RequestBody Employee request) {

        Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new NotFoundException(id));

        employeeService.updateEmployee(employee, request);

        return id; //TODO return 값 변경
    }

    @DeleteMapping("/{id}")
    public Long deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

}
