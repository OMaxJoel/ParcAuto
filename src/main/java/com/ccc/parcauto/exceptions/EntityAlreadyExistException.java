package com.ccc.parcauto.exceptions;

public class EntityAlreadyExistException extends RuntimeException{
    public EntityAlreadyExistException(String message)
    {
        super(message);
    }
}
