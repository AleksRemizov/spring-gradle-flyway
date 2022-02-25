package com.remizov.brest.exception;

public class NoFoundPersonsException extends RuntimeException{
    public NoFoundPersonsException() {
    }

    public NoFoundPersonsException(String message) {
        super(message);
    }
}
