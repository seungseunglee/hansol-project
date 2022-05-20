package com.hansol.hansolproject.service;

import com.hansol.hansolproject.domain.Work;
import com.hansol.hansolproject.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    public Work getWorkById(Long id) {

        final Work work = workMapper.selectWorkById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "work #" + id + " is not founded"));

        return work;
    }

    @Override
    public Work getWorkByCode(String code) {

        final Work work = workMapper.selectWorkByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "work #" + code + " is not founded"));

        return work;
    }

    @Override
    public Long createWork(String code, String name) {

        Optional<Work> isPresent = workMapper.selectWorkByCode(code);

        if (isPresent.isPresent()) {
            return isPresent.get().getId();
        }

        Work work = new Work();
        work.setCode(code);
        work.setName(name);

        workMapper.insertWork(work);

        return work.getId();
    }

    @Override
    public void updateWork(Long id, String code, String name) {

        final Work work = workMapper.selectWorkById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "work #" + id + " is not founded"));

        work.setCode(code);
        work.setName(name);

        workMapper.updateWork(work);
    }

    @Override
    public void deleteWork(Long id) {

        workMapper.selectWorkById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "work #" + id + " is not founded"));

        workMapper.deleteWork(id);
    }
}
