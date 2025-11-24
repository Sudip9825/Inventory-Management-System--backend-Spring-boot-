package com.sudip.application.Inventory.Management.System.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {
    private boolean success;
    private String message;
    private int statusCode;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:s a" )
    private LocalDateTime timestamp;
    private T data;

    public ApiResponse(boolean success, String message, int statusCode, LocalDateTime timestamp) {
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }

    public ApiResponse(boolean success, String message, int statusCode) {
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
    }

    public ApiResponse(boolean success, String message, int statusCode, T data) {
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }
}
