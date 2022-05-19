package com.hansol.hansolproject.mapper;

import com.hansol.hansolproject.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMapper {

    Long insertEmployee(Employee employee);

    List<Employee> selectAllEmployees();

    Optional<Employee> selectEmployeeById(Long id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long employee);

}
