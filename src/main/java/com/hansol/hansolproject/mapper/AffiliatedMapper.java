package com.hansol.hansolproject.mapper;

import com.hansol.hansolproject.domain.Affiliated;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AffiliatedMapper {

    Long insertAffiliated(Affiliated affiliated);

    List<Affiliated> selectAllAffiliateds();

    Optional<Affiliated> selectAffiliatedById(Long id);
    List<Affiliated> selectAffiliatedsByEmployeeId(Long id);
    List<Affiliated> selectAffiliatedsByCompanyId(Long id);

    void updateAffiliated(Affiliated affiliated);

    void deleteAffiliated(Long affiliated);
}
