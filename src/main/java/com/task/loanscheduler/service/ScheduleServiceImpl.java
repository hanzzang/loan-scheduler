package com.task.loanscheduler.service;

import com.task.loanscheduler.domain.Schedule;
import com.task.loanscheduler.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public void update(Long scheduleId, ScheduleUpdateDto updateParam) {
        scheduleRepository.update(scheduleId, updateParam);
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public List<Schedule> findSchedules(Long loanId) {
        return scheduleRepository.findAllByLoanId(loanId);
    }

    @Override
    public void deleteByLoanId(Long loanId) {
        scheduleRepository.deleteByLoanId(loanId);
    }
}
