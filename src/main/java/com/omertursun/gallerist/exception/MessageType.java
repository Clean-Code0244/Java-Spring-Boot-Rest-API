package com.omertursun.gallerist.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    NO_RECORD_EXISTS("1004","No record exists"),
    GENERAL_EXCEPTION("9999","General Exception Occured"),
    INVALID_CREDENTIALS("1005","Invalid credentials"),
    REFRESH_TOKEN_NOT_FOUND("1006","Refresh Token Not Found"),
    REFRESH_TOKEN_EXPIRED("1007","Refresh Token Expired"),
    INVALID_ADDRESS("1008","Invalid Address"),
    INVALID_ACCOUNT("1009","Invalid Account"),
    TOKEN_IS_EXPIRED("1005","Token süresi doldu");



    private String code;
    private String message;

     MessageType(String code, String message){
        this.code = code;
        this.message = message;
    }
}
