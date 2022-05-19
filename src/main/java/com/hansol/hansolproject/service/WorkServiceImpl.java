package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Work;
import com.hansol.hansolproject.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WorkServiceImpl implements WorkService {
    
    private final WorkMapper workMapper;

    @Autowired
    public WorkServiceImpl(WorkMapper workMapper) {
        this.workMapper = workMapper;
    }

    @Override
    public List<Work> getAllWorks() {
        return workMapper.selectAllWorks();
    }

    @Override
    public Optional<Work> getWorkById(Long id) {
        return workMapper.selectWorkById(id);
    }

    @Override
    public Long createWork(String code, String name) {
        Work work = new Work();
        work.setCode(code);
        work.setName(name);

        workMapper.insertWork(work);

        return work.getId();
    }

    @Override
    public void updateWork(Work work, String code, String name) {
        work.setCode(code);
        work.setName(name);

        workMapper.updateWork(work);
    }

    @Override
    public void deleteWork(Long id) {
        workMapper.deleteWork(id);
    }
}
