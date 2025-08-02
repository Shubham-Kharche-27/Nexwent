package com.shubham.Nexwent.Exception;

public class TicketsNotFoundException extends RuntimeException {
    public TicketsNotFoundException(String message) {
        super(message);
    }
}
