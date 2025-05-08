package com.omertursun.gallerist.service;

import com.omertursun.gallerist.dto.DtoGallerist;
import com.omertursun.gallerist.dto.DtoGalleristUI;

public interface IGalleristService {

    public DtoGallerist saveGallerist(DtoGalleristUI dtoGalleristUI);
}
