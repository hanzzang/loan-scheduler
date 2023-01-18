package com.task.loanscheduler.service;

import com.task.loanscheduler.domain.Loan;
import com.task.loanscheduler.repository.LoanSearchCond;
import com.task.loanscheduler.repository.LoanUpdateDto;

import java.util.List;
import java.util.Optional;

public interface LoanService {

    Loan save(Loan loan);

    void update(Long loanId, LoanUpdateDto updateParam);

    Optional<Loan> findById(Long id);

    List<Loan> findLoans(LoanSearchCond loanSearch);
}
