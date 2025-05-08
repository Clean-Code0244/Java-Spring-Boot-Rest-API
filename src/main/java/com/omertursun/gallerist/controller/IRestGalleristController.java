package com.omertursun.gallerist.controller;

import com.omertursun.gallerist.dto.DtoGallerist;
import com.omertursun.gallerist.dto.DtoGalleristUI;

public interface IRestGalleristController {

    public RootEntity<DtoGallerist> saveGallerist(DtoGalleristUI dtoGalleristUI);
}
