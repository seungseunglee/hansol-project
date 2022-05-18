package com.hansol.hansolproject.database;

import com.hansol.hansolproject.mapper.EmployeeMapper;
import com.hansol.hansolproject.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void getEmployeeByIdTest() {

        Optional<Employee> employee = employeeMapper.selectEmployeeById(1L);
        assertThat(employee.orElse(new Employee("?", "?")).getName()).isEqualTo("손흥민");
    }
}

//TODO Optional 예외 처리하기