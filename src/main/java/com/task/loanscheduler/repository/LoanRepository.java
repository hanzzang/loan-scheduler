package com.task.loanscheduler.repository;

import com.task.loanscheduler.domain.Loan;
import java.util.List;
import java.util.Optional;

public interface LoanRepository {

    Loan save(Loan loan);

    void update(Long loanId, LoanUpdateDto updateParam);

    Optional<Loan> findById(Long id);

    List<Loan> findAll(LoanSearchCond cond);

}
