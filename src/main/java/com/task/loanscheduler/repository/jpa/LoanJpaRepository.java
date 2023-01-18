package com.task.loanscheduler.repository.jpa;

import com.task.loanscheduler.domain.Loan;
import com.task.loanscheduler.domain.LoanType;
import com.task.loanscheduler.repository.LoanRepository;
import com.task.loanscheduler.repository.LoanSearchCond;
import com.task.loanscheduler.repository.LoanUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class LoanJpaRepository implements LoanRepository {

    private final LoanSpringJpaRepository repository;

    @Override
    public Loan save(Loan loan) {
        return repository.save(loan);
    }

    @Override
    public void update(Long LoanId, LoanUpdateDto updateParam) {
        Loan findLoan = repository.findById(LoanId).orElseThrow();
        findLoan.setLoanType(updateParam.getLoanType());
        findLoan.setLoanAmount(updateParam.getLoanAmount());
        findLoan.setLoanDate(updateParam.getLoanDate());
        findLoan.setLoanTerm(updateParam.getLoanTerm());
        findLoan.setInterestRate(updateParam.getInterestRate());
    }

    @Override
    public Optional<Loan> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Loan> findAll(LoanSearchCond cond) {
        LoanType loanType = cond.getLoanType();
        Long maxAmount = cond.getMaxAmount();

        if (loanType != null && maxAmount != null) {
            return repository.findLoans(loanType, maxAmount);
        } else if (loanType != null) {
            return repository.findByLoanTypeLike(loanType);
        } else if (maxAmount != null) {
            return repository.findByLoanAmountLessThanEqual(maxAmount);
        } else {
            return repository.findAll();
        }
    }
}
