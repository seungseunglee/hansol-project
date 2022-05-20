package com.hansol.hansolproject.domain;

import lombok.Data;

@Data
public class Affiliated {

    private long id;
    private Employee employee;
    private Company company;
}
