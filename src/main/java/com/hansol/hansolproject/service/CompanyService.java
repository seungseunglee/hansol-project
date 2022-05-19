package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    
    List<Company> getAllCompanys();
    Optional<Company> getCompanyById(Long id);
    Long createCompany(String name);
    void updateCompany(Company company, String name);
    void deleteCompany(Long id);
}
