package com.account.accountmicroservice.exceptions;

public class NoAccountFoundException extends RuntimeException{
    public NoAccountFoundException(String message) {
        super(message);
    }
}
