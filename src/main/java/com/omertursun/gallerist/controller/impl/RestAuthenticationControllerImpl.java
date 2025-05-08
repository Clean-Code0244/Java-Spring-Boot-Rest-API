package com.omertursun.gallerist.controller.impl;

import com.omertursun.gallerist.controller.IRestAuthenticationController;
import com.omertursun.gallerist.controller.RestBaseController;
import com.omertursun.gallerist.controller.RootEntity;
import com.omertursun.gallerist.dto.AuthRequest;
import com.omertursun.gallerist.dto.AuthResponse;
import com.omertursun.gallerist.dto.DtoUser;
import com.omertursun.gallerist.dto.RefreshTokenRequest;
import com.omertursun.gallerist.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {


    private IAuthenticationService authenticationService;

    public RestAuthenticationControllerImpl(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest authRequest) {
        return ok(authenticationService.register(authRequest));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest authRequest) {
        return ok(authenticationService.authenticate(authRequest));
    }

    @PostMapping("/refresh-token")
    @Override
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ok(authenticationService.refreshToken(refreshTokenRequest));
    }
}
