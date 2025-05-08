package com.omertursun.gallerist.service;

import com.omertursun.gallerist.dto.AuthRequest;
import com.omertursun.gallerist.dto.AuthResponse;
import com.omertursun.gallerist.dto.DtoUser;
import com.omertursun.gallerist.dto.RefreshTokenRequest;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest authRequest);
    public AuthResponse authenticate(AuthRequest authRequest);

    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
