package com.omertursun.gallerist.service;

import com.omertursun.gallerist.dto.DtoAccount;
import com.omertursun.gallerist.dto.DtoAccountUI;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountUI dtoAccountUI);
}
