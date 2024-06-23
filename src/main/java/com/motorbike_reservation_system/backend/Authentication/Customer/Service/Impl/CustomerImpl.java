package com.motorbike_reservation_system.backend.Authentication.Customer.Service.Impl;

import com.motorbike_reservation_system.backend.Authentication.Customer.Dto.CustomerDTO;
import com.motorbike_reservation_system.backend.Authentication.Customer.Dto.CustomerLoginDTO;
import com.motorbike_reservation_system.backend.Authentication.Customer.Dto.ProfileImageDTO;
import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.Customer;
import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.CustomerAddress;
import com.motorbike_reservation_system.backend.Authentication.Customer.Repo.CustomerAddressRepo;
import com.motorbike_reservation_system.backend.Authentication.Customer.Repo.CustomerRepo;
import com.motorbike_reservation_system.backend.Authentication.Customer.Response.CustomerLoginResponse;
import com.motorbike_reservation_system.backend.Authentication.Customer.Service.CustomerEmailService;
import com.motorbike_reservation_system.backend.Authentication.Customer.Service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerAddressRepo customerAddressRepo;
    @Autowired
    private CustomerEmailService customerEmailService;


    @Override
    public int addCustomer(CustomerDTO customerDTO) {
        Customer customer = Customer.builder()
                .customerId(customerDTO.getCustomerId())
                .customerName(customerDTO.getCustomerName())
                .customerEmail(customerDTO.getCustomerEmail())
                .customerPhoneNumber(customerDTO.getCustomerPhoneNumber())
                .customerUsername(customerDTO.getCustomerUsername())
                .customerPassword(this.passwordEncoder.encode(customerDTO.getCustomerPassword()))
                .activeStatus(Optional.ofNullable(customerDTO.getActiveStatus()).orElse("active"))
                .build();
        customerRepo.save(customer);

        // Send confirmation email
        customerEmailService.sendRegistrationConfirmation(customer.getCustomerEmail(), customer.getCustomerName());

        return customer.getCustomerId();
    }

    @Override
    @Transactional
    public void updateCustomerDetails(int customerId, CustomerDTO customerDTO) {
        // Retrieve the existing customer from the database
        Customer existingCustomer = customerRepo.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        // Check which fields are provided by the user and update accordingly
        if (customerDTO.getCustomerName() != null) {
            existingCustomer.setCustomerName(customerDTO.getCustomerName());
        }
        if (customerDTO.getCustomerEmail() != null) {
            existingCustomer.setCustomerEmail(customerDTO.getCustomerEmail());
        }
        if (customerDTO.getCustomerPhoneNumber() != null) {
            existingCustomer.setCustomerPhoneNumber(customerDTO.getCustomerPhoneNumber());
        }
        if (customerDTO.getCustomerUsername() != null) {
            existingCustomer.setCustomerUsername(customerDTO.getCustomerUsername());
        }

        // Check if the password is provided by the user, otherwise use the existing password
        String customerPassword = customerDTO.getCustomerPassword();
        if (customerPassword == null) {
            customerPassword = existingCustomer.getCustomerPassword();
        }

        // Update the password
        existingCustomer.setCustomerPassword(passwordEncoder.encode(customerPassword));

        // Save the updated customer
        customerRepo.save(existingCustomer);
    }




    public List<Customer> getCustomer() {
        return customerRepo.findAll();
    }
    @Override
    public CustomerLoginResponse loginCustomer(CustomerLoginDTO customerLoginDTO) {
        String msg="";
        Customer customer1 = customerRepo.findByCustomerEmail(customerLoginDTO.getCustomerEmail());
        if(customer1!= null){
            String password = customerLoginDTO.getCustomerPassword();
            String encodePassword = customer1.getCustomerPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodePassword);
            if (isPasswordRight){
                Optional<Customer> employee = customerRepo.findOneByCustomerEmailAndCustomerPassword(customerLoginDTO.getCustomerEmail(), encodePassword);
                if (employee.isPresent()){
                    return new CustomerLoginResponse(customer1.getCustomerId(), "Login Successfully",true );
                }
                else return new CustomerLoginResponse(0,"Login Failed",false);
            }
            else return new CustomerLoginResponse(0,"Password not Match", false);
        }
        else return new CustomerLoginResponse(0,"Email not Exists",false);
    }

    @Transactional
    public void updateActiveStatus(int customerId, String activeStatus) {
        customerRepo.updateActiveStatus(customerId, activeStatus);
        if ("deactive".equalsIgnoreCase(activeStatus)) {
            Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
            customerEmailService.sendDeactivationNotification(customer.getCustomerEmail(), customer.getCustomerName());
        }
    }



    public Customer getCustomerById(int customerId) {
        return customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("User not found"));
    }


    // Customer Address
    @Override
    public String addCustomerAddress(CustomerAddress customerAddress) {
        customerAddress = CustomerAddress.builder()
                .customerAddressId(customerAddress.getCustomerAddressId())
                .street(customerAddress.getStreet())
                .city(customerAddress.getCity())
                .State(customerAddress.getState())
                //.activeStatus(Optional.ofNullable(customerDTO.getActiveStatus()).orElse("active"))
                .build();
        customerAddressRepo.save(customerAddress);
        return customerAddress.getCustomerAddressId();
    }

    public List<CustomerAddress> getCustomerAddress(){
        return customerAddressRepo.findAll();
    }

    // Profile Image

//    public int addProfileImage(ProfileImageDTO profileImage) {
//        Customer customer = customerRepo.findByCustomerId(profileImage.getCustomerId());
//        Customer customer1 = Customer.builder()
//                .customerId(customer.getCustomerId())
//                .profileImage(profileImage.getProfileImage())
//                .build();
//        customerRepo.save(customer1);
//        return customer1.getCustomerId();
//    }
//
//    public List<Customer> getProfileImage(){
//        return customerRepo.findAll();
//    }

    public ProfileImageDTO getProfileImageById(int customerId) {
        Customer customer = customerRepo.findByCustomerId(customerId);
               // .orElseThrow(() -> new RuntimeException("User not found"));
        return ProfileImageDTO.builder()
                .customerId(customer.getCustomerId())
                .profileImage(customer.getProfileImage())
                .build();
    }

    public void deleteProfileImage(int customerId) {
        Customer customer = customerRepo.findByCustomerId(customerId);
                //.orElseThrow(() -> new RuntimeException("User not found"));
        customer.setProfileImage(null);
        customerRepo.save(customer);
    }

    public ProfileImageDTO updateProfileImage(ProfileImageDTO profileImageDTO) {
        Customer existingCustomer = customerRepo.findByCustomerId(profileImageDTO.getCustomerId());
               // .orElseThrow(() -> new RuntimeException("User not found"));
        existingCustomer.setProfileImage(profileImageDTO.getProfileImage());
        customerRepo.save(existingCustomer);
        return profileImageDTO;
    }



}