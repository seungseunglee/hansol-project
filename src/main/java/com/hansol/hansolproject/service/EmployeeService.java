package com.hansol.hansolproject.service;

import com.hansol.hansolproject.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
}
