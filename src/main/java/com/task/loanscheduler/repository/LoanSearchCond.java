package com.task.loanscheduler.repository;

import com.task.loanscheduler.domain.LoanType;
import lombok.Data;

@Data
public class LoanSearchCond {

    private LoanType loanType;
    private Long maxAmount;

    public LoanSearchCond() {
    }

    public LoanSearchCond(LoanType loanType, Long maxAmount) {
        this.loanType = loanType;
        this.maxAmount = maxAmount;
    }
}
