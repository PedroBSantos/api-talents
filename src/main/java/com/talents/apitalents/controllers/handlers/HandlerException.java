package com.talents.apitalents.controllers.handlers;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.talents.apitalents.dtos.error.ErrorDTO;
import com.talents.apitalents.services.exceptions.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ EntityNotFoundException.class })
    public ResponseEntity<ErrorDTO> entityNotFound(EntityNotFoundException entityNotFoundException,
            HttpServletRequest request) {
        String path = request.getRequestURI();
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_FOUND.value(), Instant.now(), "Resource not found", path,
                entityNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<ErrorDTO> accessDenied(AccessDeniedException accessDeniedException,
            HttpServletRequest request) {
        String path = request.getRequestURI();
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.FORBIDDEN.value(), Instant.now(), "Access denied for this resource",
                accessDeniedException.getMessage(), path);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorDTO);
    }
}
