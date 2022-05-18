package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Long createEmployee(Employee employee);
    List<Employee> getEmployeeById();
    Optional<Employee> getEmployeeById(Long id);
    Long updateEmployee(Employee oldEmp, Employee newEmp);
    Long deleteEmployee(Long id);

}
