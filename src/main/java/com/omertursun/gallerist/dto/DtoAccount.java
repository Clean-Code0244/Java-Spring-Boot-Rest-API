package com.omertursun.gallerist.dto;

import com.omertursun.gallerist.enums.CurrencyType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DtoAccount extends DtoBase{

    private String accountNo;

    private String iban;

    private BigDecimal amount;

    private CurrencyType currencyType;
}
