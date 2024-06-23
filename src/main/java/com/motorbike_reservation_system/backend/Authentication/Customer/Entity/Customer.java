package com.motorbike_reservation_system.backend.Authentication.Customer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motorbike_reservation_system.backend.Feedback.Feedback;
import com.motorbike_reservation_system.backend.Motorbike.Motorbike;
import com.motorbike_reservation_system.backend.Repair_Service.Repair;
import com.motorbike_reservation_system.backend.Reservation.Reservation;
import com.motorbike_reservation_system.backend.payment.Payment;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerUsername;
    private String customerPassword;
    private String activeStatus;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] profileImage;


    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Motorbike> motorbikes;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Payment> Payment;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Repair> repairs;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CustomerAddress> customerAddresses;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;



}
//
//package com.motorbike_reservation_system.backend.Authentication.Customer.Entity;
//
//import com.motorbike_reservation_system.backend.Motorbike.Motorbike;
//import com.motorbike_reservation_system.backend.Repair_Service.Repair;
//import com.motorbike_reservation_system.backend.Reservation.Reservation;
//import jakarta.persistence.*;
//
//        import java.util.List;
//
//@Entity
//@Table(name="customer")
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int customerId;
//    private String customerName;
//    private String customerEmail;
//    private String customerPhoneNumber;
//    private String customerUsername;
//    private String customerPassword;
//
//
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Motorbike> motorbikes;
//
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Reservation> reservations;
//
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Repair> repairs;
//
//    public Customer() {
//    }
//
//    public Customer(int customerId, String customerName, String customerEmail , String customerPhoneNumber, String customerUsername, String customerPassword) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.customerEmail = customerEmail;
//        this.customerPhoneNumber = customerPhoneNumber;
//        this.customerUsername = customerUsername;
//        this.customerPassword = customerPassword;
//
//    }
//
//    public Customer(String customerName, String customerEmail , String customerPhoneNumber, String customerUsername, String customerPassword) {
//        this.customerName = customerName;
//        this.customerEmail = customerEmail;
//        this.customerPhoneNumber = customerPhoneNumber;
//        this.customerUsername = customerUsername;
//        this.customerPassword = customerPassword;
//
//    }
//
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerEmail() {
//        return customerEmail;
//    }
//
//    public void setCustomerEmail(String customerEmail) {
//        this.customerEmail = customerEmail;
//    }
//
//    public String getCustomerPhoneNumber() {
//        return customerPhoneNumber;
//    }
//
//    public void setCustomerPhoneNumber(String customerPhoneNumber) {
//        this.customerPhoneNumber = customerPhoneNumber;
//    }
//
//    public String getCustomerUsername() {
//        return customerUsername;
//    }
//
//    public void setCustomerUsername(String customerUsername) {
//        this.customerUsername = customerUsername;
//    }
//
//    public String getCustomerPassword() {
//        return customerPassword;
//    }
//
//    public void setCustomerPassword(String customerPassword) {
//        this.customerPassword = customerPassword;
//    }
//
//    public List<Motorbike> getMotorbikes() {
//        return motorbikes;
//    }
//
//    public void setMotorbikes(List<Motorbike> motorbikes) {
//        this.motorbikes = motorbikes;
//    }
//
//    public List<Reservation> getReservations() {
//        return reservations;
//    }
//
//    public void setReservations(List<Reservation> reservations) {
//        this.reservations = reservations;
//    }
//
//    public List<Repair> getRepairs() {
//        return repairs;
//    }
//
//    public void setRepairs(List<Repair> repairs) {
//        this.repairs = repairs;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customerId=" + customerId +
//                ", customerName='" + customerName + '\'' +
//                ", customerEmail='" + customerEmail + '\'' +
//                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
//                ", customerUsername='" + customerUsername + '\'' +
//                ", customerPassword='" + customerPassword + '\'' +
//                '}';
//    }
//
//}