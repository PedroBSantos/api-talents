package com.talents.apitalents.services.exceptions;

public class DuplicatedDataException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DuplicatedDataException(String message) {
        super(message);
    }
}
