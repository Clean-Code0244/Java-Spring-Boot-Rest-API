package com.omertursun.gallerist.repository;

import com.omertursun.gallerist.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
