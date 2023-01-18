package com.task.loanscheduler;

import com.task.loanscheduler.config.SpringDataJpaConfig;
import com.task.loanscheduler.domain.Loan;
import com.task.loanscheduler.repository.LoanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Slf4j
@Import(SpringDataJpaConfig.class)
@SpringBootApplication
public class LoanSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanSchedulerApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(LoanRepository loanRepository) {
		return new TestDataInit(loanRepository);
	}
}
