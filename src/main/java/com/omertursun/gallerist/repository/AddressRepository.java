package com.omertursun.gallerist.repository;

import com.omertursun.gallerist.model.Account;
import com.omertursun.gallerist.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


    Optional<Account> getAddressById(Long id);
}
