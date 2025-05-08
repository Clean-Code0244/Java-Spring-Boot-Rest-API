package com.omertursun.gallerist.controller;

import com.omertursun.gallerist.dto.AuthRequest;
import com.omertursun.gallerist.dto.AuthResponse;
import com.omertursun.gallerist.dto.DtoUser;
import com.omertursun.gallerist.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {
    public RootEntity<DtoUser> register(AuthRequest authRequest);
    public RootEntity<AuthResponse> authenticate(AuthRequest authRequest);
    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest refreshTokenRequest);
}
