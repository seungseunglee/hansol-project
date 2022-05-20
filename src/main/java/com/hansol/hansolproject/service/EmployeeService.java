package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Long createEmployee(String name, String position, String task, String telephone, Long workId);
    void updateEmployee(Long id, String name, String position, String task, String telephone, Long workId);
    void deleteEmployee(Long id);

}
