package com.omertursun.gallerist.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gallerist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gallerist extends BaseEntity {

    private String firstName;
    private String lastName;
    @OneToOne
    private Address address;
}
