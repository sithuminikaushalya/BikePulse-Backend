package com.motorbike_reservation_system.backend.Authentication.Customer.Repo;

import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    Optional<Customer> findOneByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);
    Customer findByCustomerEmail(String customerEmail);

    Customer findByCustomerId(int customerId);

    // Define a method to update customer details
    @Modifying
    @Query("UPDATE Customer c SET c.customerName = :customerName, c.customerEmail = :customerEmail, " +
            "c.customerPhoneNumber = :customerPhoneNumber, c.customerUsername = :customerUsername, " +
            " c.customerPassword = :customerPassword " +
            "WHERE c.customerId = :customerId")
    void updateCustomerDetails(@Param("customerId") int customerId,
                               @Param("customerName") String customerName,
                               @Param("customerEmail") String customerEmail,
                               @Param("customerPhoneNumber") String customerPhoneNumber,
                               @Param("customerUsername") String customerUsername,
                               @Param("customerPassword") String customerPassword);

    @Modifying
    @Transactional
    @Query("UPDATE Customer u SET u.activeStatus = :activeStatus WHERE u.customerId = :customerId")
    void updateActiveStatus(@Param("customerId") int customerId, @Param("activeStatus") String activeStatus);


}
