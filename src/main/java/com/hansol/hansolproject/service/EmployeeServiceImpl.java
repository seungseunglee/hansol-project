package com.hansol.hansolproject.service;

import com.hansol.hansolproject.mapper.EmployeeMapper;
import com.hansol.hansolproject.model.Employee;
import com.hansol.hansolproject.repository.EmployeeRepository;
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
    public List<Employee> getAllEmployees() {
        return employeeMapper.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeMapper.findById(id);
    }

}
