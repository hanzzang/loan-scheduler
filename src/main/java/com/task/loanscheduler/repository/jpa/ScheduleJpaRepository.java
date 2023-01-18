package com.task.loanscheduler.repository.jpa;

import com.task.loanscheduler.domain.Schedule;
import com.task.loanscheduler.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ScheduleJpaRepository implements ScheduleRepository {

    private final ScheduleSpringJpaRepository repository;

    @Override
    public Schedule save(Schedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public void update(Long scheduleId, ScheduleUpdateDto updateParam) {
        Schedule findSchedule = repository.findById(scheduleId).orElseThrow();
        findSchedule.setPaymentCount(updateParam.getPaymentCount());
        findSchedule.setPaymentDate(updateParam.getPaymentDate());
        findSchedule.setMonthlyPayment(updateParam.getMonthlyPayment());
        findSchedule.setMonthlyPrincipal(updateParam.getMonthlyPrincipal());
        findSchedule.setMonthlyInterest(updateParam.getMonthlyInterest());
        findSchedule.setLoanBalance(updateParam.getLoanBalance());
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Schedule> findAllByLoanId(Long loanId) {
        return repository.findAllByLoanId(loanId);
    }

    @Override
    public void deleteByLoanId(Long loanId) {
        repository.deleteAllByLoanId(loanId);
    }
}
