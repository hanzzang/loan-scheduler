package com.task.loanscheduler.domain;

public enum LoanType {
    P("원금균등상환"), PI("원리금균등상환");

    private final String description;

    LoanType(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
