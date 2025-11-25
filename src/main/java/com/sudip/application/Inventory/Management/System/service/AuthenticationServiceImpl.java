package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.core.dto.ApiResponse;
import com.sudip.application.Inventory.Management.System.core.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
@Autowired
private AuthenticationManager authenticationManager;

    @Override
    public ApiResponse<?> authenticate(LoginRequest loginRequest) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken( loginRequest.getEmail(),loginRequest.getPassword())
            );
            return new ApiResponse<>(true,"lOGGED IN SUCCESSFULLY",200);
        }
        catch (BadCredentialsException e){
            throw new BadCredentialsException("Invalid email or password");
        }

    }
}
