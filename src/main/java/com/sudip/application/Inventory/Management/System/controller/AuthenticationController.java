package com.sudip.application.Inventory.Management.System.controller;

import com.sudip.application.Inventory.Management.System.core.dto.ApiResponse;
import com.sudip.application.Inventory.Management.System.core.dto.LoginRequest;
import com.sudip.application.Inventory.Management.System.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("/api/auth ")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> saveUsers(@RequestBody @Valid  LoginRequest loginRequest) {
        ApiResponse<?> apiResponse=   authenticationService.authenticate(loginRequest);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }
}


