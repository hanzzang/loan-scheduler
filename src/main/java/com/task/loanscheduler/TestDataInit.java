package com.task.loanscheduler;

import com.task.loanscheduler.domain.Loan;
import com.task.loanscheduler.domain.LoanType;
import com.task.loanscheduler.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {

    private final LoanRepository loanRepository;

    /**
     * 확인용 초기 데이터 추가
     */
    @EventListener(ApplicationReadyEvent.class)
    public void initData() throws ParseException {
        log.info("test data init...");

        loanRepository.save(new Loan(10000000L, 1.5, LoanType.P, 24, "2023-01-16"));
        loanRepository.save(new Loan(20000000L, 2.5, LoanType.PI, 36, "2023-01-16"));
    }

}
