package com.sudip.application.Inventory.Management.System.exception.handler;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String message) {
        super(message);
    }
}