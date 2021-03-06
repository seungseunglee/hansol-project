package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Affiliated;

import java.util.List;

public interface AffiliatedService {

    List<Affiliated> getAllAffiliateds();
    Affiliated getAffiliatedById(Long id);
    List<Affiliated> getAffiliatedsByEmployeeId(Long id);
    List<Affiliated> getAffiliatedsByCompanyId(Long id);
    Long createAffiliated(Long employeeId, Long companyId);
    void updateAffiliated(Long id, Long employeeId, Long companyId);
    void deleteAffiliated(Long id);

}