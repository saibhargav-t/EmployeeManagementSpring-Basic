package com.spring.projects.employees.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeesExceptionHandler {

    @ExceptionHandler
    ResponseEntity<Error> handleException(EmployeeRecordNotFoundException e) {
        Error error = new Error();
        error.setErrorId(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(e.getMessage());
        error.setErrorTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<Error> handleAll(Exception e) {
        Error error = new Error();
        error.setErrorId(HttpStatus.BAD_REQUEST.value());
        error.setErrorMessage(e.getLocalizedMessage());
        error.setErrorTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<Error> handleIdCannotChangeException(IdCannotChangeException e) {
        Error error = new Error();
        error.setErrorId(HttpStatus.FORBIDDEN.value());
        error.setErrorMessage("Id changes cannot be allowed. Contact Admin");
        error.setErrorTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
        
    }
}
