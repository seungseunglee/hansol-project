package com.hansol.hansolproject.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class Global {

    private String workCode;
    private String workName;
    private String company;
    private String empName;
    private String position;
    private String task;
    private String telephone;
}
