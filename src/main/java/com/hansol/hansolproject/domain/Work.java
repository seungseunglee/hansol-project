package com.hansol.hansolproject.domain;

import lombok.*;

@Data
public class Work {

    private Long id;
    @NonNull
    private String code;
    @NonNull
    private String name;

}
