package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Company;
import com.hansol.hansolproject.domain.Work;
import com.hansol.hansolproject.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyServiceImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public List<Company> getAllCompanys() {
        return companyMapper.selectAllCompanys();
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyMapper.selectCompanyById(id);
    }

    @Override
    public Long createCompany(String name) {
        Company company = new Company();
        company.setName(name);

        companyMapper.insertCompany(company);

        return company.getId();
    }

    @Override
    public void updateCompany(Company company, String name) {
        company.setName(name);

        companyMapper.updateCompany(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyMapper.deleteCompany(id);
    }
}
