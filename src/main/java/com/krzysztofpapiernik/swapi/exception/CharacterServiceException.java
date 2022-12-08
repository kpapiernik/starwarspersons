package com.krzysztofpapiernik.swapi.exception;

public class CharacterServiceException extends RuntimeException{

    public CharacterServiceException(String message) {
        super(message);
    }
}
