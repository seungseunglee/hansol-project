package com.hansol.hansolproject.mapper;

import com.hansol.hansolproject.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee")
    List<Employee> findAll();
    @Select("select * from employee where id=#{id}")
    Optional<Employee> findById(Long id);


}
