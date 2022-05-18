package com.hansol.hansolproject.service;

import com.hansol.hansolproject.mapper.EmployeeMapper;
import com.hansol.hansolproject.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Long createEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
        return employee.getId();
    }

    @Override
    public List<Employee> getEmployeeById() {
        return employeeMapper.selectAllEmployees();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeMapper.selectEmployeeById(id);
    }

    @Override
    public Long updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public Long deleteEmployee(Employee employee) {
        return employeeMapper.deleteEmployee(employee);
    }



}
