package com.krzysztofpapiernik.swapi.controller;

import com.krzysztofpapiernik.swapi.controller.dto.ResponseDto;
import com.krzysztofpapiernik.swapi.exception.CharacterServiceException;
import com.krzysztofpapiernik.swapi.service.validator.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(CharacterServiceException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseDto<?> characterServiceExceptionHandler(CharacterServiceException err){
        return new ResponseDto<>(err.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> validationExceptionHandler(ValidationException err){
        return new ResponseDto<>(err.getMessage());
    }
}
