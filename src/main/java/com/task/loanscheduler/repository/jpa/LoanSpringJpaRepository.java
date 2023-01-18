package com.task.loanscheduler.repository.jpa;

import com.task.loanscheduler.domain.Loan;
import com.task.loanscheduler.domain.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanSpringJpaRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByLoanTypeLike(LoanType loanType);

    List<Loan> findByLoanAmountLessThanEqual(Long loanAmount);

    //쿼리 메서드 (아래 메서드와 같은 기능 수행)
    List<Loan> findByLoanTypeLikeAndLoanAmountLessThanEqual(LoanType loanType, Long loanAmount);

    //쿼리 직접 실행
    @Query("select i from Loan i where i.loanType like :loanType and i.loanAmount <= :loanAmount")
    List<Loan> findLoans(@Param("loanType") LoanType loanType, @Param("loanAmount") Long loanAmount);

}
