package com.task.loanscheduler.config;

import com.task.loanscheduler.repository.LoanRepository;
import com.task.loanscheduler.repository.ScheduleRepository;
import com.task.loanscheduler.repository.jpa.LoanJpaRepository;
import com.task.loanscheduler.repository.jpa.LoanSpringJpaRepository;
import com.task.loanscheduler.repository.jpa.ScheduleJpaRepository;
import com.task.loanscheduler.repository.jpa.ScheduleSpringJpaRepository;
import com.task.loanscheduler.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringDataJpaConfig {

    private final LoanSpringJpaRepository loanSpringJpaRepository;
    private final ScheduleSpringJpaRepository scheduleSpringJpaRepository;

    @Bean
    public LoanService loanService() {
        return new LoanServiceImpl(loanRepository());
    }

    @Bean
    public LoanRepository loanRepository() {
        return new LoanJpaRepository(loanSpringJpaRepository);
    }

    public ScheduleService scheduleService() {
        return new ScheduleServiceImpl(scheduleReposotory());
    }

    public ScheduleRepository scheduleReposotory() {
        return new ScheduleJpaRepository(scheduleSpringJpaRepository);
    }

}
