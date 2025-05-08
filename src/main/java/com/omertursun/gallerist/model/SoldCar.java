package com.omertursun.gallerist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sold_car" , uniqueConstraints = {@UniqueConstraint(columnNames = {"gallerist_id","car_id","customer_id"},name = "uq_gallerist_car_customer")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoldCar extends BaseEntity {
    @ManyToOne()
    private Gallerist gallerist;

    @ManyToOne()
    private Car car;

    @ManyToOne()
    private Customer customer;
}
