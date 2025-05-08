package com.omertursun.gallerist.repository;

import com.omertursun.gallerist.model.Gallerist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleristRepository extends JpaRepository<Gallerist, Long> {
}
