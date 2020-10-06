package com.talents.apitalents.controllers.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ DataIntegrityViolationException.class, EmptyResultDataAccessException.class,
            NoSuchElementException.class })
    public ResponseEntity<Object> dataIntegrityViolationException(Exception exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> accessDeniedException(Exception exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
