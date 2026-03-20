package com.pushan.restapis.Employee_address.Repository;

import com.pushan.restapis.Employee_address.Entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
