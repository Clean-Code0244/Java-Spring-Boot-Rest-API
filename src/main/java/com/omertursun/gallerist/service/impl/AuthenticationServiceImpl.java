package com.omertursun.gallerist.service.impl;

import com.omertursun.gallerist.dto.AuthRequest;
import com.omertursun.gallerist.dto.AuthResponse;
import com.omertursun.gallerist.dto.DtoUser;
import com.omertursun.gallerist.dto.RefreshTokenRequest;
import com.omertursun.gallerist.exception.BaseException;
import com.omertursun.gallerist.exception.ErrorMessage;
import com.omertursun.gallerist.exception.MessageType;
import com.omertursun.gallerist.jwt.JWTService;
import com.omertursun.gallerist.model.RefreshToken;
import com.omertursun.gallerist.model.User;
import com.omertursun.gallerist.repository.RefreshTokenRepository;
import com.omertursun.gallerist.repository.UserRepository;
import com.omertursun.gallerist.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private AuthenticationProvider authenticationProvider;
    private JWTService jwtService;
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationProvider authenticationProvider, JWTService jwtService, RefreshTokenRepository refreshTokenRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationProvider = authenticationProvider;
        this.jwtService = jwtService;
        this.refreshTokenRepository = refreshTokenRepository;
    }



    private User createUser(AuthRequest authRequest) {
        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(authRequest.getPassword()));
        user.setCreateTime(new Date());
        return user;
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreateTime(new Date());
        refreshToken.setExpiryDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return null;
    }
    @Override
    public DtoUser register(AuthRequest authRequest) {
        DtoUser dtoUser = new DtoUser();
        User savedUser = userRepository.save(createUser(authRequest));

        BeanUtils.copyProperties(savedUser, dtoUser);

        return dtoUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {

        try{
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            Authentication authentication = authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
            Optional<User> optUser = userRepository.findByUserName(authRequest.getUsername());
            String accessToken = jwtService.generateToken(optUser.get());
            RefreshToken refreshToken = createRefreshToken(optUser.get());
            RefreshToken savedRefreshToken = refreshTokenRepository.save(refreshToken);
            return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken());

        }
        catch(Exception e){
            throw new BaseException(new ErrorMessage(MessageType.INVALID_CREDENTIALS,e.getMessage()));
        }

    }
    public boolean isRefreshTokenValid(Date expiryDate) {
        return new Date().before(expiryDate);

    }
    @Override
    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByRefreshToken(refreshTokenRequest.getRefreshToken());
        if(refreshToken.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND,refreshTokenRequest.getRefreshToken()));
        }
        if(!isRefreshTokenValid(refreshToken.get().getExpiryDate())) {
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_EXPIRED,refreshTokenRequest.getRefreshToken()));
        }

        User user = refreshToken.get().getUser();
        String accessToken = jwtService.generateToken(user);
        RefreshToken refreshToken1 = createRefreshToken(refreshToken.get().getUser());
         RefreshToken refreshToken2 = refreshTokenRepository.save(refreshToken1);
        return new AuthResponse(accessToken,refreshToken2.getRefreshToken());
    }
}
