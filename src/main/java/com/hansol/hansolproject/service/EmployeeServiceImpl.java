package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Work;
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
    public List<Employee> getAllEmployees() {
        return employeeMapper.selectAllEmployees();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeMapper.selectEmployeeById(id);
    }

    @Override
    public Long createEmployee(String name, String position, String task, String telephone, Long workId) {
        Work work = new Work();
        work.setId(workId);
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);
        employee.setTask(task);
        employee.setTelephone(telephone);
        employee.setWork(work);

        employeeMapper.insertEmployee(employee);

        return employee.getId();
    }

    @Override
    public void updateEmployee(Employee employee, String name, String position, String task, String telephone, Long workId) {
        employee.setName(name);
        employee.setPosition(position);
        employee.setTask(task);
        employee.setTelephone(telephone);
        employee.getWork().setId(workId);

        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeMapper.deleteEmployee(id);
    }
}
