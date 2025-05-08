package com.omertursun.gallerist.service;

import com.omertursun.gallerist.dto.DtoAddress;
import com.omertursun.gallerist.dto.DtoAddressUI;

public interface IAddressService {
    public DtoAddress saveAddress(DtoAddressUI dtoAddressUI);
}
