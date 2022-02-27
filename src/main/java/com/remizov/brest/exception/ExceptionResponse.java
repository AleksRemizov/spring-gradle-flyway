package com.remizov.brest.exception;

import java.util.Arrays;
import java.util.List;

public class ExceptionResponse {

    private  String message;
    private  List<String> details;

    public ExceptionResponse(){
        super();
    }

    public ExceptionResponse(final String  message, final List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    public ExceptionResponse(final String  message, final Exception ex) {
        super();
        this.message = message;
        if (ex != null) {
            this.details = Arrays.asList(ex.getMessage());
        }
    }

    public String getMessage() {
        return message;
    }

    public ExceptionResponse setMessage( final String message) {
        this.message = message;
        return this;
    }

    public List<String> getDetails() {
        return details;
    }

    public ExceptionResponse setDetails(final List<String> details) {
        this.details = details;
        return this;
    }
}
