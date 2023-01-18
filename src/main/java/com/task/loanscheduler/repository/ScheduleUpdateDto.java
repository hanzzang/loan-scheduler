package com.task.loanscheduler.repository;

import lombok.Data;

import javax.persistence.Column;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class ScheduleUpdateDto {
    private Long Id;
    private Long loanId;
    private Integer paymentCount;
    private String paymentDate;
    private Long monthlyPayment;
    private Long monthlyPrincipal;
    private Long monthlyInterest;
    private Long loanBalance;
    private Long interestBalance;

    public ScheduleUpdateDto() {
    }

    public ScheduleUpdateDto(Long loanId, Integer paymentCount, String paymentDate, Long monthlyPayment,
                             Long monthlyPrincipal, Long monthlyInterest, Long loanBalance, Long interestBalance) {
        this.loanId = loanId;
        this.paymentCount = paymentCount;
        this.paymentDate = paymentDate;
        this.monthlyPayment = monthlyPayment;
        this.monthlyPrincipal = monthlyPrincipal;
        this.monthlyInterest = monthlyInterest;
        this.loanBalance = loanBalance;
        this.interestBalance = interestBalance;
    }
}
