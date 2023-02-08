package com.cards.cardsmicroservice.exceptions;

public class NoCardFoundException extends RuntimeException{
    public NoCardFoundException(String message) {
        super(message);
    }
}
