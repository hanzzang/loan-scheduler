package com.task.loanscheduler.service;

import com.task.loanscheduler.domain.Loan;
import com.task.loanscheduler.domain.Schedule;

import java.util.List;

public interface CalculateService {

    List<Schedule> calculateLoanP(Loan loan);

    List<Schedule> calculateLoanPI(Loan loan);
}
