package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Global;

import java.util.List;

public interface GlobalService {

    List<Global> getAll();
    Global getByEmployeeId(Long id);
    void createGlobal(String workCode, String workName, String company, String empName, String position, String task, String telephone);
    void updateGlobal(Long id, String workCode, String workName, String company, String empName, String position, String task, String telephone);
    void deleteGlobal(Long id);

}
