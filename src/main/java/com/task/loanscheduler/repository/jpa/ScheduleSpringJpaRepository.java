package com.task.loanscheduler.repository.jpa;

import com.task.loanscheduler.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ScheduleSpringJpaRepository extends JpaRepository<Schedule, Long> {

    //쿼리 직접 실행
    @Query("select i from Schedule i where i.loanId = :loanId")
    List<Schedule> findAllByLoanId(@Param("loanId") Long loanId);

    //쿼리 직접 실행
    @Modifying
    @Transactional
    @Query("delete from Schedule i where i.loanId = :loanId")
    void deleteAllByLoanId(@Param("loanId") Long loanId);
}
