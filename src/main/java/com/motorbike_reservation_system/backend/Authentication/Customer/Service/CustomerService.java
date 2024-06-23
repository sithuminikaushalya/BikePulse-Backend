package com.motorbike_reservation_system.backend.Authentication.Customer.Service;

import com.motorbike_reservation_system.backend.Authentication.Customer.Dto.CustomerDTO;
import com.motorbike_reservation_system.backend.Authentication.Customer.Dto.CustomerLoginDTO;
import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.CustomerAddress;
import com.motorbike_reservation_system.backend.Authentication.Customer.Response.CustomerLoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    int addCustomer(CustomerDTO customerDTO);

    CustomerLoginResponse loginCustomer(CustomerLoginDTO customerLoginDTO);

    String addCustomerAddress(CustomerAddress customerAddress);

    void updateCustomerDetails(int customerId, CustomerDTO customerDTO);
}
