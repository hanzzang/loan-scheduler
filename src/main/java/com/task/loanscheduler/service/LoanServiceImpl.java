package com.task.loanscheduler.service;

import com.task.loanscheduler.domain.Loan;
import com.task.loanscheduler.repository.LoanRepository;
import com.task.loanscheduler.repository.LoanSearchCond;
import com.task.loanscheduler.repository.LoanUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public void update(Long loanId, LoanUpdateDto updateParam) {
        loanRepository.update(loanId, updateParam);
    }

    @Override
    public Optional<Loan> findById(Long id) {
        return loanRepository.findById(id);
    }

    @Override
    public List<Loan> findLoans(LoanSearchCond cond) {
        return loanRepository.findAll(cond);
    }
}
