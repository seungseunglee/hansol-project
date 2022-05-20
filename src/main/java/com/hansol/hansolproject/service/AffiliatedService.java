package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Affiliated;

import java.util.List;
import java.util.Optional;

public interface AffiliatedService {

    List<Affiliated> getAllAffiliateds();
    Optional<Affiliated> getAffiliatedById(Long id);
    Long createAffiliated(Long employeeId, Long companyId);
    void updateAffiliated(Affiliated affiliated, Long employeeId, Long companyId);
    void deleteAffiliated(Long id);

}