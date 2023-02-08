package com.loans.loansmicroserivce.exceptions;

public class NoLoanFoundException extends RuntimeException {
    public NoLoanFoundException(String message) {
        super(message);
    }
}
