package com.krzysztofpapiernik.swapi.service.validator;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
