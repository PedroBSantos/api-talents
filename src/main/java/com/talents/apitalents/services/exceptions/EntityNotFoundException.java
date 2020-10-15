package com.talents.apitalents.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(Integer id) {
        super("No data found for id: " + id);
    }

    public EntityNotFoundException(String string) {
        super("No data found for: " + string);
    }
}
