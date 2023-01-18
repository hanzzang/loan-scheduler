package com.task.loanscheduler.web;

import com.task.loanscheduler.repository.LoanRepository;
import com.task.loanscheduler.repository.ScheduleRepository;
import com.task.loanscheduler.service.CalculateService;
import com.task.loanscheduler.service.LoanService;
import com.task.loanscheduler.service.ScheduleService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoanScheduleControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanService loanService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CalculateService calculateService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    void create_test() {
    }

    @Test
    void read_test() {
    }

    @Test
    void update_test() {
    }
}