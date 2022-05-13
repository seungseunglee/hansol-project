package com.hansol.hansolproject.model;

import lombok.*;

@Data
public class Employee {

    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String company1;
    private String company2;
    @NonNull
    private String position;
    private String task;
    private String telephone;

}
