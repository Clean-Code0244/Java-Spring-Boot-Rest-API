package com.omertursun.gallerist.dto;

import com.omertursun.gallerist.model.Address;
import lombok.Data;

@Data
public class DtoGallerist extends DtoBase{

    private String firstName;
    private String lastName;

    private Address address;

}
