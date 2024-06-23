package com.motorbike_reservation_system.backend.Authentication.Customer.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class CustomerAddress {

    @Id
    private String customerAddressId;
    private String street;
    private String city;
    private String State;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;


    /////// Custom logic to generate the next available ID //////////////////////////////////////

    @PrePersist
    public void generateId() {
        if (customerAddressId == null) {
            // Generate a random 6-digit number
            java.lang.String randomDigits = generateRandomDigits(6);

            // Assign the ID as "FM" followed by the random digits
            this.customerAddressId = "CA" + randomDigits;
        }
    }

    private java.lang.String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
