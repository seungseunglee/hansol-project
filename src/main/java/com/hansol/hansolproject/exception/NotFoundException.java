package com.hansol.hansolproject.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1284355715948868204L;
    private Long id;

    public NotFoundException(Long id) {
        this.id = id;
    }
}
