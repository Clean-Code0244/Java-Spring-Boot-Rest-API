package com.omertursun.gallerist.dto;

import lombok.Data;

@Data
public class DtoCustomer extends DtoBase {

    private String firstName;

    private String lastName;

    private String tckn;

    private String birthOfDate;

    private DtoAddress address;

    private DtoAccount account;

}
