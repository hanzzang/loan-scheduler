package com.task.loanscheduler.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_amount")
    private Long loanAmount;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "loan_type")
    @Enumerated(EnumType.STRING)
    private LoanType loanType;

    @Column(name = "loan_term")
    private Integer loanTerm;

    @Column(name = "loan_date")
    private String loanDate;

    public Loan() {
    }

    public Loan(Long loanAmount, Double interestRate, LoanType loanType, Integer loanTerm, String loanDate) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanType = loanType;
        this.loanTerm = loanTerm;
        this.loanDate = loanDate;
    }
}
