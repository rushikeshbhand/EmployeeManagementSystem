package com.projectems.exceptions;

@SuppressWarnings("serial")
public class ManagerNotFoundException extends RuntimeException {

    public ManagerNotFoundException() {
        super();
    }

    public ManagerNotFoundException(String message) {
        super(message);
    }

    public ManagerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
