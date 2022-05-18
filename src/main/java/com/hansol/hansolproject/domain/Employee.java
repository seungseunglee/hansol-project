package com.hansol.hansolproject.domain;

import lombok.*;

@Data
public class Employee {

    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String position;
    private String task;
    private String telephone;
    private Work work;

}
