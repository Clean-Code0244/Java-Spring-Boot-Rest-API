package com.omertursun.gallerist.service;

import com.omertursun.gallerist.dto.DtoCustomer;
import com.omertursun.gallerist.dto.DtoCustomerUI;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerUI dtoCustomerUI);

}
