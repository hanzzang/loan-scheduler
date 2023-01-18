package com.task.loanscheduler.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_id")
    private Long loanId;

    @Column(name = "payment_count")
    private Integer paymentCount;

    @Column(name = "payment_date")
    private String paymentDate;

    @Column(name = "monthly_payment")
    private Long monthlyPayment;

    @Column(name = "monthly_principal")
    private Long monthlyPrincipal;

    @Column(name = "monthly_interest")
    private Long monthlyInterest;

    @Column(name = "loan_balance")
    private Long loanBalance;

    @Column(name = "interest_balance")
    private Long interestBalance;

    public Schedule() {
    }

    public Schedule(Integer paymentCount, Long loanId, String paymentDate, Long monthlyPayment, Long monthlyPrincipal,
                    Long monthlyInterest, Long loanBalance, Long interestBalance) {
        this.paymentCount = paymentCount;
        this.loanId = loanId;
        this.paymentDate = paymentDate;
        this.monthlyPayment = monthlyPayment;
        this.monthlyPrincipal = monthlyPrincipal;
        this.monthlyInterest = monthlyInterest;
        this.loanBalance = loanBalance;
        this.interestBalance = interestBalance;
    }
}
