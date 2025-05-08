package com.omertursun.gallerist.controller.impl;

import com.omertursun.gallerist.controller.IRestAddressController;
import com.omertursun.gallerist.controller.RestBaseController;
import com.omertursun.gallerist.controller.RootEntity;
import com.omertursun.gallerist.dto.DtoAddress;
import com.omertursun.gallerist.dto.DtoAddressUI;
import com.omertursun.gallerist.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {

    private IAddressService addressService;

    public RestAddressControllerImpl(IAddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid  @RequestBody  DtoAddressUI dtoAddressUI) {
        return ok(addressService.saveAddress(dtoAddressUI));
    }

}
