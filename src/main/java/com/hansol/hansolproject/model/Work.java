package com.hansol.hansolproject.model;

import lombok.*;

@Data
public class Work {

    private Long id;
    @NonNull
    private String code;
    @NonNull
    private String name;

}
