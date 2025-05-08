package com.omertursun.gallerist.controller;

import com.omertursun.gallerist.dto.DtoAddress;
import com.omertursun.gallerist.dto.DtoAddressUI;

public interface IRestAddressController {
    public RootEntity<DtoAddress> saveAddress(DtoAddressUI dtoAddressUI);
}
