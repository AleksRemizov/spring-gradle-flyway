package com.remizov.brest.exception;

public class NoUniqueEntityException extends RuntimeException{

    public NoUniqueEntityException() {
    }
    public NoUniqueEntityException(String message) {
        super(message);
    }

    public NoUniqueEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
