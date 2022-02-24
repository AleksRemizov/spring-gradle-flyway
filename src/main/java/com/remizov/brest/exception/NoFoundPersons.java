package com.remizov.brest.exception;

public class NoFoundPersons extends Exception{
    public NoFoundPersons() {
    }

    public NoFoundPersons(String message) {
        super(message);
    }
}
