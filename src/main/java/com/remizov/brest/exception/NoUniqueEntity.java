package com.remizov.brest.exception;

public class NoUniqueEntity extends Exception{
    public NoUniqueEntity() {
    }

    public NoUniqueEntity(String message) {
        super(message);
    }

    public NoUniqueEntity(String message, Throwable cause) {
        super(message, cause);
    }
}
