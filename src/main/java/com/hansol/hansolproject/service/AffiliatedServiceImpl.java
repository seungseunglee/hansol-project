package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Affiliated;
import com.hansol.hansolproject.domain.Company;
import com.hansol.hansolproject.domain.Employee;
import com.hansol.hansolproject.mapper.AffiliatedMapper;
import com.hansol.hansolproject.mapper.CompanyMapper;
import com.hansol.hansolproject.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AffiliatedServiceImpl implements AffiliatedService {

    private final AffiliatedMapper affiliatedMapper;
    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @Autowired
    public AffiliatedServiceImpl(AffiliatedMapper affiliatedMapper, EmployeeService employeeService, CompanyService companyService) {
        this.affiliatedMapper = affiliatedMapper;
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @Override
    public List<Affiliated> getAllAffiliateds() {
        return affiliatedMapper.selectAllAffiliateds();
    }

    @Override
    public Affiliated getAffiliatedById(Long id) {

        final Affiliated affiliated = affiliatedMapper.selectAffiliatedById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "affiliated #" + id + " is not founded"));

        return affiliated;
    }

    @Override
    public List<Affiliated> getAffiliatedsByEmployeeId(Long id) {

        return affiliatedMapper.selectAffiliatedsByEmployeeId(id);
    }

    @Override
    public List<Affiliated> getAffiliatedsByCompanyId(Long id) {

        return affiliatedMapper.selectAffiliatedsByCompanyId(id);
    }

    @Override
    public Long createAffiliated(Long employeeId, Long companyId) {

        Optional<Affiliated> isPresent = affiliatedMapper.selectAffiliatedByEmployeeIdAndCompanyId(employeeId, companyId);

        if (isPresent.isPresent()) {
            return isPresent.get().getId();
        }

        employeeService.getEmployeeById(employeeId);
        companyService.getCompanyById(companyId);

        Employee employee = new Employee();
        employee.setId(employeeId);

        Company company = new Company();
        company.setId(companyId);

        Affiliated affiliated = new Affiliated();
        affiliated.setEmployee(employee);
        affiliated.setCompany(company);

        affiliatedMapper.insertAffiliated(affiliated);

        return affiliated.getId();
    }

    @Override
    public void updateAffiliated(Long id, Long employeeId, Long companyId) {

        employeeService.getEmployeeById(employeeId);
        companyService.getCompanyById(companyId);

        final Affiliated affiliated = affiliatedMapper.selectAffiliatedById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "affiliated #" + id + " is not founded"));

        affiliated.getEmployee().setId(employeeId);
        affiliated.getCompany().setId(companyId);

        affiliatedMapper.updateAffiliated(affiliated);
    }

    @Override
    public void deleteAffiliated(Long id) {

        affiliatedMapper.selectAffiliatedById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "affiliated #" + id + " is not founded"));

        affiliatedMapper.deleteAffiliated(id);
    }
}

