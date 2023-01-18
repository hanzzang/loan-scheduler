package com.task.loanscheduler.repository;

import com.task.loanscheduler.domain.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    Schedule save(Schedule schedule);

    void update(Long scheduleId, ScheduleUpdateDto updateParam);

    Optional<Schedule> findById(Long id);

    List<Schedule> findAllByLoanId(Long loanId);

    void deleteByLoanId(Long loanId);
}
