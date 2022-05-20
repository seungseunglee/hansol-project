package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Affiliated;
import com.hansol.hansolproject.domain.Company;
import com.hansol.hansolproject.domain.Employee;
import com.hansol.hansolproject.mapper.AffiliatedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AffiliatedServiceImpl implements AffiliatedService {

    private final AffiliatedMapper affiliatedMapper;

    @Autowired
    public AffiliatedServiceImpl(AffiliatedMapper affiliatedMapper) {
        this.affiliatedMapper = affiliatedMapper;
    }

    @Override
    public List<Affiliated> getAllAffiliateds() {
        return affiliatedMapper.selectAllAffiliateds();
    }

    @Override
    public Optional<Affiliated> getAffiliatedById(Long id) {
        return affiliatedMapper.selectAffiliatedById(id);
    }

    @Override
    public Long createAffiliated(Long employeeId, Long companyId) {

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
    public void updateAffiliated(Affiliated affiliated, Long employeeId, Long companyId) {
        affiliated.getEmployee().setId(employeeId);
        affiliated.getCompany().setId(companyId);

        affiliatedMapper.updateAffiliated(affiliated);
    }

    @Override
    public void deleteAffiliated(Long id) {
        affiliatedMapper.deleteAffiliated(id);
    }
}

