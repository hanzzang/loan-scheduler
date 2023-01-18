package com.task.loanscheduler.service;

import com.task.loanscheduler.domain.Loan;
import com.task.loanscheduler.domain.LoanType;
import com.task.loanscheduler.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateServiceImpl implements CalculateService {

    @Override
    public List<Schedule> calculateLoanP(Loan loan) {
        List<Schedule> scheduleList = new ArrayList<>();

        Long id = loan.getId();
        Long loanAmount = loan.getLoanAmount();
        Double interestRate = loan.getInterestRate();
        LoanType loanType = loan.getLoanType();
        int loanTerm = loan.getLoanTerm();
        String loanDate = loan.getLoanDate();

        Long loanId = 0L;
        Long interestTotal = 0L;                  //총이자
        Long paymentCount = 0L;                   //상환순서
        String paymentDate = "";                  //상환일
        Long monthlyPayment = 0L;                 //월불입금
        Long monthlyPrincipal = 0L;               //월원금
        Long monthlyInterest = 0L;                //월이자
        Long loanBalance = 0L;                    //남은대출원금
        Long interestBalance = 0L;                //남은대출원금

        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate strToLocalDate = LocalDate.parse(loanDate, dtFormat);

        loanBalance = loanAmount;
        monthlyPrincipal = loanAmount / loanTerm;
        double yearInterestRate = interestRate / 12 / 100;
        loanId = id;

        for(int i = 1; i <= loanTerm; i++){
            monthlyInterest = Math.round(loanBalance * yearInterestRate);
            interestTotal += monthlyInterest;
            loanBalance = (loanBalance - monthlyPrincipal < 0) ? 0 : (loanBalance - monthlyPrincipal);
            paymentDate = strToLocalDate.plusMonths(i).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            monthlyPayment = monthlyPrincipal + monthlyInterest;
            interestBalance = interestTotal - monthlyInterest;

            Schedule schedule = new Schedule(i, loanId, paymentDate, monthlyPayment, monthlyPrincipal, monthlyInterest, loanBalance, interestBalance);
            scheduleList.add(schedule);
        }

        return (scheduleList.size() == 0) ? null : scheduleList;
    }

    @Override
    public List<Schedule> calculateLoanPI(Loan loan) {
        List<Schedule> scheduleList = new ArrayList<>();

        Long id = loan.getId();
        Long loanAmount = loan.getLoanAmount();
        Double interestRate = loan.getInterestRate();
        LoanType loanType = loan.getLoanType();
        int loanTerm = loan.getLoanTerm();
        String loanDate = loan.getLoanDate();

        Long loanId = 0L;
        Long interestTotal = 0L;                  //총이자
        Long paymentCount = 0L;                   //상환순서
        String paymentDate = "";                  //상환일
        Long monthlyPayment = 0L;                 //월불입금
        Long monthlyPrincipal = 0L;               //월원금
        Long monthlyInterest = 0L;                //월이자
        Long loanBalance = 0L;                    //남은대출원금
        Long interestBalance = 0L;                //남은대출원금

        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate strToLocalDate = LocalDate.parse(loanDate, dtFormat);

        loanBalance = loanAmount;
        monthlyPrincipal = loanAmount / loanTerm;
        double yearInterestRate = interestRate / 12 / 100;
        loanId = id;

        double denominator = Math.pow(yearInterestRate + 1, loanTerm) -1;                                   // 분모
        double molecule = loanAmount * yearInterestRate * ((Math.pow(yearInterestRate + 1, loanTerm)));     // 분자

        monthlyPayment = Math.round(molecule / denominator);    //월불입금

        for(int i = 1; i <= loanTerm; i++){
            monthlyInterest = Math.round(loanBalance * yearInterestRate);
            interestTotal += monthlyInterest;
            monthlyPrincipal = monthlyPayment - monthlyInterest;
            loanBalance = (loanBalance - monthlyPrincipal < 0) ? 0 : (loanBalance - monthlyPrincipal);
            paymentDate = strToLocalDate.plusMonths(i).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            interestBalance = interestTotal - monthlyInterest;

            Schedule schedule = new Schedule(i, loanId, paymentDate, monthlyPayment, monthlyPrincipal, monthlyInterest, loanBalance, interestBalance);
            scheduleList.add(schedule);
        }

        return (scheduleList.size() == 0) ? null : scheduleList;
    }
}
