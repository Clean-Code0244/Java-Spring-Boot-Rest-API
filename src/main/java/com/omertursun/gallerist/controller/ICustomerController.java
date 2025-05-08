package com.omertursun.gallerist.controller;

import com.omertursun.gallerist.dto.DtoCustomer;
import com.omertursun.gallerist.dto.DtoCustomerUI;
import com.omertursun.gallerist.model.Customer;

public interface ICustomerController {

    public RootEntity<DtoCustomer> createCustomer(DtoCustomerUI dtoCustomerUI);
}
