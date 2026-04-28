package com.example.deal.ex;

public class DealNotFoundException extends RuntimeException {

    public DealNotFoundException(String message) {
        super(message);
    }

    public DealNotFoundException(Long id) {
        super("Deal not found with id: " + id);
    }

    public DealNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
