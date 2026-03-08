package com.JPA.employee_address_app.repository;

import com.JPA.employee_address_app.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
