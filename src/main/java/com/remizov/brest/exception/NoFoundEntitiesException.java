package com.remizov.brest.exception;

public class NoFoundEntitiesException extends RuntimeException{

    public NoFoundEntitiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFoundEntitiesException() {
    }

    public NoFoundEntitiesException(String message) {
        super(message);
    }
}
