package com.omertursun.gallerist.model;


import com.omertursun.gallerist.enums.CarStatusType;
import com.omertursun.gallerist.enums.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {
    private String plaka;
    private String brand;
    private String model;
    private Integer productionYear;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
    private BigDecimal damagePrice;
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatus;
}
