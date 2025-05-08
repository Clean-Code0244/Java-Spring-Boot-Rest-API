package com.omertursun.gallerist.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "refresh_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken extends BaseEntity {

    private String refreshToken;
    private Date expiryDate;
    @ManyToOne()
    private User user;

}
