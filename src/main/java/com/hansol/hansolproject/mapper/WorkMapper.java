package com.hansol.hansolproject.mapper;

import com.hansol.hansolproject.domain.Employee;
import com.hansol.hansolproject.domain.Work;
import com.hansol.hansolproject.domain.Work;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface WorkMapper {

    Long insertWork(Work work);

    List<Work> selectAllWorks();

    Optional<Work> selectWorkById(Long id);
    Optional<Work> selectWorkByCode(String code);

    void updateWork(Work work);

    void deleteWork(Long work);
}
