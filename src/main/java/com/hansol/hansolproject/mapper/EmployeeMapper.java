package com.hansol.hansolproject.mapper;

import com.hansol.hansolproject.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMapper {

    void insertEmployee(Employee employee); //TODO return Long

    List<Employee> selectAllEmployees();

    Optional<Employee> selectEmployeeById(Long id);

    Long updateEmployee(Employee employee);

    Long deleteEmployee(Employee employee);

}
