package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Work;

import java.util.List;
import java.util.Optional;

public interface WorkService {

    List<Work> getAllWorks();
    Optional<Work> getWorkById(Long id);
    Long createWork(String code, String name);
    void updateWork(Work work, String code, String name);
    void deleteWork(Long id);
}
