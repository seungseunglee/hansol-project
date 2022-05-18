package com.hansol.hansolproject.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Company {

    private Long id;
    @NonNull
    private String name;
}
