package com.talents.apitalents.controllers.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ DataIntegrityViolationException.class, EmptyResultDataAccessException.class })
    public ResponseEntity<Object> dataIntegrityViolationException(Exception exception) {
        return ResponseEntity.notFound().build();
    }
}
