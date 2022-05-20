package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Company;
import com.hansol.hansolproject.domain.Work;
import com.hansol.hansolproject.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    public Company getCompanyById(Long id) {

        final Company company = companyMapper.selectCompanyById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "company #" + id + " is not founded"));

        return company;
    }

    @Override
    public Long createCompany(String name) {

        Optional<Company> isPresent = companyMapper.selectCompanyByName(name);

        if (isPresent.isPresent()) {
            return isPresent.get().getId();
        }

        Company company = new Company();
        company.setName(name);

        companyMapper.insertCompany(company);

        return company.getId();
    }

    @Override
    public void updateCompany(Long id, String name) {

        final Company company = companyMapper.selectCompanyById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "company #" + id + " is not founded"));

        company.setName(name);

        companyMapper.updateCompany(company);
    }

    @Override
    public void deleteCompany(Long id) {

        companyMapper.selectCompanyById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "company #" + id + " is not founded"));

        companyMapper.deleteCompany(id);
    }
}
