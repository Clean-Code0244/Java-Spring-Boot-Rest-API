package com.omertursun.gallerist.model;

import com.omertursun.gallerist.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {


    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "iban")
    private String iban;

    @Column(name = "amount")
    //parasal işlemler hassasiyet içerdiği için BigDecimal ile beraber kullanılır
    private BigDecimal amount;

    @Column(name = "curreny_type")
    @Enumerated(EnumType.STRING)
    //EnumType.ORDINAL olması durumunda sayısal değerler ile kaydedilecektir veri tabanına
    private CurrencyType currencyType;


}
