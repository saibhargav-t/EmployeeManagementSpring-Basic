package com.spring.projects.employees.exceptionhandling;

public class Error {
    private int errorId;
    private String errorMessage;
    private long errorTimeStamp;

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getErrorTimeStamp() {
        return errorTimeStamp;
    }

    public void setErrorTimeStamp(long errorTimeStamp) {
        this.errorTimeStamp = errorTimeStamp;
    }

    Error() {

    }

    public Error(int errorId, String errorMessage, long errorTimeStamp) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
        this.errorTimeStamp = errorTimeStamp;
    }

}
