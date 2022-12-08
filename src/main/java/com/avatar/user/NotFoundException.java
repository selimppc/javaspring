package com.avatar.user;


public class NotFoundException extends RuntimeException {
    private String message;

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public NotFoundException() {

    }
}
