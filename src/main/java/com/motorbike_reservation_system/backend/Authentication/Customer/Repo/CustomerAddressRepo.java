package com.motorbike_reservation_system.backend.Authentication.Customer.Repo;

import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepo extends JpaRepository<CustomerAddress, String> {

    CustomerAddress findByCustomerAddressId(String customerAddressId);

}
