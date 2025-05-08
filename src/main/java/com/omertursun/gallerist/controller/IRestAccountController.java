package com.omertursun.gallerist.controller;

import com.omertursun.gallerist.dto.DtoAccount;
import com.omertursun.gallerist.dto.DtoAccountUI;

public interface IRestAccountController {

    public RootEntity<DtoAccount> createAccount(DtoAccountUI dtoAccountUI);
}
