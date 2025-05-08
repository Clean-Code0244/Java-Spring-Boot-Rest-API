package com.omertursun.gallerist.dto;

import com.omertursun.gallerist.enums.CurrencyType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DtoAccountUI {


    private String accountNo;

    private String iban;

    private BigDecimal amount;

    private CurrencyType currencyType;

}
