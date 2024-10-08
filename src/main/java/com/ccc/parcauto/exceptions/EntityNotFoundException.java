package com.ccc.parcauto.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message)
    {
        super(message);
    }
}
