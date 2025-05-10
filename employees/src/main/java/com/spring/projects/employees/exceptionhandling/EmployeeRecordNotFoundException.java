package com.spring.projects.employees.exceptionhandling;

public class EmployeeRecordNotFoundException extends RuntimeException {
    public EmployeeRecordNotFoundException(String message) {
        super(message);
    }

}
