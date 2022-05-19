package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Long createEmployee(String name, String position, String task, String telephone, Long workId);
    void updateEmployee(Employee employee, String name, String position, String task, String telephone, Long workId);
    void deleteEmployee(Long id);

}
