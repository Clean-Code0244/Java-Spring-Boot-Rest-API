package com.omertursun.gallerist.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {


    private String firstName;
    private String lastName;
    private String tckn;
    private String birthOfDate;

    @OneToOne()
    private Address address;
    @OneToOne()
    private Account account;
}
