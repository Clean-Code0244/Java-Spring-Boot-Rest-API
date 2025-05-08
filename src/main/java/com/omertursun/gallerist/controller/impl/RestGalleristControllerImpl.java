package com.omertursun.gallerist.controller.impl;

import com.omertursun.gallerist.controller.IRestGalleristController;
import com.omertursun.gallerist.controller.RestBaseController;
import com.omertursun.gallerist.controller.RootEntity;
import com.omertursun.gallerist.dto.DtoGallerist;
import com.omertursun.gallerist.dto.DtoGalleristUI;
import com.omertursun.gallerist.service.IGalleristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestGalleristControllerImpl extends RestBaseController implements IRestGalleristController {

    private IGalleristService galleristService;

    @Autowired
    public void setGalleristService(IGalleristService galleristService) {
        this.galleristService = galleristService;
    }

    @Override
    public RootEntity<DtoGallerist> saveGallerist(DtoGalleristUI dtoGalleristUI) {
        return ok(galleristService.saveGallerist(dtoGalleristUI));
    }
}
