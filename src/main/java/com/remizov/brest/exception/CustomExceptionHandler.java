package com.remizov.brest.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final String DATA_BASE_ERROR = "Error database!";
    private final String VALIDATION_ERROR = "Validation error!";

    @ExceptionHandler(NoFoundEntitiesException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<ExceptionResponse> handleNoFoundPersonsException
            (NoFoundEntitiesException e, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(e.getMessage(),
                                                          Arrays.asList(e.getClass().getName()));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<ExceptionResponse> handleNoFoundException
            (PersonNotFoundException e , WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(e.getMessage(),
                Arrays.asList(e.getClass().getName()));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<ExceptionResponse> handleNoFoundException
            (TaskNotFoundException e , WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(e.getMessage(),
                Arrays.asList(e.getClass().getName()));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler({NoUniqueEntityException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public final ResponseEntity<ExceptionResponse> handleNoUniqueEntityException
            (NoUniqueEntityException e, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(e.getMessage(),
                Arrays.asList(e.getClass().getName()));

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> handleDataIntegrityViolationException
            (DataIntegrityViolationException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        ExceptionResponse error = new ExceptionResponse(DATA_BASE_ERROR,
                Arrays.asList(ex.getClass().getName()));
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(Exception ex, WebRequest request) {

        return new ResponseEntity<>(
                new ExceptionResponse(VALIDATION_ERROR, ex),
                HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
