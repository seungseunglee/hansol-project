package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Global;

import java.util.List;

public interface GlobalService {

    List<Global> getAll();
    Global getByEmployeeId(Long id);

}
