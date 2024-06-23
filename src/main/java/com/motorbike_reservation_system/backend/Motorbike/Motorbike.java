package com.motorbike_reservation_system.backend.Motorbike;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Random;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "motorbike")
public class Motorbike {

    @Id
    private String motorbikeId;
    private String motorbikeName;
    private String motorbikeType;
    private String motorbikeNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

//
//    public Motorbike() {
//    }
//
//    public Motorbike(String  motorbikeId, String motorbikeName, String motorbikeType, String motorbikeNumber, Customer customer) {
//        this.motorbikeId = motorbikeId;
//        this.motorbikeName = motorbikeName;
//        this.motorbikeType = motorbikeType;
//        this.motorbikeNumber = motorbikeNumber;
//        this.customer = customer;
//    }
//
//    public Motorbike(String motorbikeName, String motorbikeType, String motorbikeNumber, Customer customer) {
//        this.motorbikeName = motorbikeName;
//        this.motorbikeType = motorbikeType;
//        this.motorbikeNumber = motorbikeNumber;
//        this.customer = customer;
//    }
//
//    public String  getMotorbikeId() {
//        return motorbikeId;
//    }
//
//    public void setMotorbikeId(String  motorbikeId) {
//        this.motorbikeId = motorbikeId;
//    }
//
//    public String getMotorbikeName() {
//        return motorbikeName;
//    }
//
//    public void setMotorbikeName(String motorbikeName) {
//        this.motorbikeName = motorbikeName;
//    }
//
//    public String getMotorbikeType() {
//        return motorbikeType;
//    }
//
//    public void setMotorbikeType(String motorbikeType) {
//        this.motorbikeType = motorbikeType;
//    }
//
//    public String getMotorbikeNumber() {
//        return motorbikeNumber;
//    }
//
//    public void setMotorbikeNumber(String motorbikeNumber) {
//        this.motorbikeNumber = motorbikeNumber;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    @Override
//    public String toString() {
//        return "Motorbike{" +
//                "motorbikeId=" + motorbikeId +
//                ", motorbikeName='" + motorbikeName + '\'' +
//                ", motorbikeType='" + motorbikeType + '\'' +
//                ", motorbikeNumber='" + motorbikeNumber + '\'' +
//                ", customer=" + customer +
//                '}';
//    }


    /////// Custom logic to generate the next available ID //////////////////////////////////////

    @PrePersist
    public void generateId() {
        if (motorbikeId == null) {
            // Generate a random 6-digit number
            String randomDigits = generateRandomDigits(6);

            // Assign the ID as "FM" followed by the random digits
            this.motorbikeId = "MB" + randomDigits;
        }
    }

    private String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }


}
