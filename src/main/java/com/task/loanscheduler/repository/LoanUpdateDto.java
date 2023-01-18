package com.task.loanscheduler.repository;

import com.task.loanscheduler.domain.LoanType;
import lombok.Data;

@Data
public class LoanUpdateDto {
    private Long loanAmount;
    private Double interestRate;
    private LoanType loanType;
    private Integer loanTerm;
    private String loanDate;

    public LoanUpdateDto() {
    }

    public LoanUpdateDto(Long loanAmount, Double interestRate, LoanType loanType,
                         Integer loanTerm, String loanDate) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanType = loanType;
        this.loanTerm = loanTerm;
        this.loanDate = loanDate;
    }
}
