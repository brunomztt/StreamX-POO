package com.company;

public class Exception extends RuntimeException {
    public Exception(String message) {
        super(message);
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }


}
