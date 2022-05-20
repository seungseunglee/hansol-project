package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Employee;
import com.hansol.hansolproject.domain.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class GlobalServiceImpl implements GlobalService {

    private final EmployeeService employeeService;
    private AffiliatedService affiliatedService;

    @Autowired
    public GlobalServiceImpl(EmployeeService employeeService, AffiliatedService affiliatedService) {
        this.employeeService = employeeService;
        this.affiliatedService = affiliatedService;
    }

    @Override
    public List<Global> getAll() {
        final List<Employee> employees = employeeService.getAllEmployees();

        final List<Global> globals = new ArrayList<>();

        for (Employee employee: employees) {

            Global global = createGlobal(employee);

            globals.add(global);
        }

        return globals;
    }

    @Override
    public Global getByEmployeeId(Long id) {
        final Employee employee = employeeService.getEmployeeById(id);

        Global global = createGlobal(employee);

        return global;
    }

    private Global createGlobal(Employee employee) {
        String company = affiliatedService.getAffiliatedByEmployeeId(employee.getId()).stream()
                .map(el -> String.valueOf(el.getCompany().getName()))
                .collect(Collectors.joining(", "));

        Global global = Global.builder()
                .workCode(employee.getWork().getCode())
                .workName(employee.getWork().getName())
                .empName(employee.getName())
                .position(employee.getPosition())
                .task(employee.getTask())
                .telephone(employee.getTelephone())
                .company(company).build();

        return global;
    }

}
