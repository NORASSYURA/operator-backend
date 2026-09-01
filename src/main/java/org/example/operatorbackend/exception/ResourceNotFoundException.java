package org.example.operatorbackend.exception;

import org.example.operatorbackend.exception.ResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}