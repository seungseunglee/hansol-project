package com.hansol.hansolproject.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Affiliated {

    private long id;
    @NonNull
    private Employee employee;
    @NonNull
    private Company company;
}
