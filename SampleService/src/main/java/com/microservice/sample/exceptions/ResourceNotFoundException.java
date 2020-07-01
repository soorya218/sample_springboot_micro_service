package com.microservice.sample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    String message;

    public ResourceNotFoundException(){}

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
