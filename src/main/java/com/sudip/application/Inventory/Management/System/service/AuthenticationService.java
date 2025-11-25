package com.sudip.application.Inventory.Management.System.service;

import com.sudip.application.Inventory.Management.System.core.dto.ApiResponse;
import com.sudip.application.Inventory.Management.System.core.dto.LoginRequest;

public interface AuthenticationService {
    ApiResponse<?> authenticate(LoginRequest loginRequest);
}
