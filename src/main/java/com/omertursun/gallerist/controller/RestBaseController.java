package com.omertursun.gallerist.controller;

public class RestBaseController {

    public <T> RootEntity<T>  ok(T payload){
        return RootEntity.ok(payload);
    }

    public <T> RootEntity<T>  erorr(String errorMessage){
        return RootEntity.error(errorMessage);
    }
}
