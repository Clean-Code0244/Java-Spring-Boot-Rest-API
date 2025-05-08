package com.omertursun.gallerist.dto;

import com.omertursun.gallerist.model.Account;
import com.omertursun.gallerist.model.Address;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class DtoCustomerUI {

    private String firstName;
    private String lastName;
    private String tckn;
    private String birthOfDate;

    private DtoAddress address;

    private DtoAccount account;

}
