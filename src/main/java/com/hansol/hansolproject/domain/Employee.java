package com.hansol.hansolproject.domain;

import lombok.*;

@Data
public class Employee {

    private Long id;
    private String name;
    private String position;
    private String task;
    private String telephone;
    private Work work;

}
