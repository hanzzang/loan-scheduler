package com.task.loanscheduler.service;

import com.task.loanscheduler.domain.Schedule;
import com.task.loanscheduler.repository.ScheduleUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    Schedule save(Schedule schedule);

    void update(Long scheduleId, ScheduleUpdateDto updateParam);

    Optional<Schedule> findById(Long id);

    List<Schedule> findSchedules(Long loanId);

    void deleteByLoanId(Long loanId);
}
