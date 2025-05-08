package com.omertursun.gallerist.controller.impl;

import com.omertursun.gallerist.controller.ICustomerController;
import com.omertursun.gallerist.controller.RestBaseController;
import com.omertursun.gallerist.controller.RootEntity;
import com.omertursun.gallerist.dto.DtoCustomer;
import com.omertursun.gallerist.dto.DtoCustomerUI;
import com.omertursun.gallerist.service.ICustomerService;

public class CustomerControllerImpl extends RestBaseController implements ICustomerController {

    private ICustomerService customerService;

    public CustomerControllerImpl(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public RootEntity<DtoCustomer> createCustomer(DtoCustomerUI dtoCustomerUI) {
        return ok(customerService.saveCustomer(dtoCustomerUI));
    }
}
