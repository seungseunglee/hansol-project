package com.hansol.hansolproject.mapper;

import com.hansol.hansolproject.domain.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CompanyMapper {
    
    Long insertCompany(Company company);

    List<Company> selectAllCompanys();

    Optional<Company> selectCompanyById(Long id);
    Optional<Company> selectCompanyByName(String name);

    void updateCompany(Company company);

    void deleteCompany(Long company);
}
