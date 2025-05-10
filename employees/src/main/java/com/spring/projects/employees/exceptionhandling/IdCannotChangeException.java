package com.spring.projects.employees.exceptionhandling;

public class IdCannotChangeException extends RuntimeException {

    public IdCannotChangeException(String message) {
        super(message);
    }

}
