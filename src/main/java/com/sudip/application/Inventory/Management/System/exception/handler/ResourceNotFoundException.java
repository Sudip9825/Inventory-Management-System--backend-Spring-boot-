package com.sudip.application.Inventory.Management.System.exception.handler;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
