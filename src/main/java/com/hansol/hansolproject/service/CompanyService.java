package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Company;

import java.util.List;

public interface CompanyService {
    
    List<Company> getAllCompanys();
    Company getCompanyById(Long id);
    Long createCompany(String name);
    void updateCompany(Long id, String name);
    void deleteCompany(Long id);
}
