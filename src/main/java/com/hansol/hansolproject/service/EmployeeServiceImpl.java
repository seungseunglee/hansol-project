package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Work;
import com.hansol.hansolproject.mapper.EmployeeMapper;
import com.hansol.hansolproject.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final WorkService workService;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper, WorkService workService) {
        this.employeeMapper = employeeMapper;
        this.workService = workService;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.selectAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Long id) {

        final Employee employee = employeeMapper.selectEmployeeById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee #" + id + " is not founded"));

        return employee;
    }

    @Override
    public Long createEmployee(String name, String position, String task, String telephone, Long workId) {

        workService.getWorkById(workId);

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
    public void updateEmployee(Long id, String name, String position, String task, String telephone, Long workId) {

        workService.getWorkById(workId);

        final Employee employee = employeeMapper.selectEmployeeById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee #" + id + " is not founded"));

        employee.setName(name);
        employee.setPosition(position);
        employee.setTask(task);
        employee.setTelephone(telephone);
        employee.getWork().setId(workId);

        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {

        employeeMapper.selectEmployeeById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee #" + id + " is not founded"));

        employeeMapper.deleteEmployee(id);
    }
}
