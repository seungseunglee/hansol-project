package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Work;

import java.util.List;

public interface WorkService {

    List<Work> getAllWorks();
    Work getWorkById(Long id);
    Long createWork(String code, String name);
    void updateWork(Long id, String code, String name);
    void deleteWork(Long id);
}
