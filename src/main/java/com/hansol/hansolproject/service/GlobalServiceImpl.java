package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Affiliated;
import com.hansol.hansolproject.domain.Employee;
import com.hansol.hansolproject.domain.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Transactional
@Service
public class GlobalServiceImpl implements GlobalService {

    private final AffiliatedService affiliatedService;
    private final CompanyService companyService;
    private final EmployeeService employeeService;
    private final WorkService workService;

    @Autowired
    public GlobalServiceImpl(AffiliatedService affiliatedService, CompanyService companyService, EmployeeService employeeService, WorkService workService) {
        this.affiliatedService = affiliatedService;
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.workService = workService;
    }

    @Override
    public List<Global> getAll() {
        final List<Employee> employees = employeeService.getAllEmployees();

        final List<Global> globals = new ArrayList<>();

        for (Employee employee: employees) {

            Global global = createInstance(employee);

            globals.add(global);
        }

        return globals;
    }

    @Override
    public Global getByEmployeeId(Long id) {
        final Employee employee = employeeService.getEmployeeById(id);

        Global global = createInstance(employee);

        return global;
    }

    @Override
    public void createGlobal(String workCode, String workName, String company, String empName, String position, String task, String telephone) {

        final Long workId = workService.createWork(workCode, workName);
        final Long employeeId = employeeService.createEmployee(empName, position, task, telephone, workId);

        String[] companys = company.trim().replace(" ", "").split(",");

        for (String com: companys) {
            Long companyId = companyService.createCompany(com);
            affiliatedService.createAffiliated(employeeId, companyId);
        }

    }

    @Override
    public void deleteGlobal(Long id) {

        affiliatedService.getAffiliatedsByEmployeeId(id)
                .stream().map(Affiliated::getId)
                .forEach(affiliatedService::deleteAffiliated);

        employeeService.deleteEmployee(id);
    }

    private Global createInstance(Employee employee) {

        String company = affiliatedService.getAffiliatedsByEmployeeId(employee.getId()).stream()
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
