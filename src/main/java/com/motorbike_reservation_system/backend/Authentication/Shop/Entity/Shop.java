package com.motorbike_reservation_system.backend.Authentication.Shop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motorbike_reservation_system.backend.Feedback.Feedback;
import com.motorbike_reservation_system.backend.Repair_Service.Repair;
import com.motorbike_reservation_system.backend.Reservation.Reservation;
import com.motorbike_reservation_system.backend.ShopsServices.ShopsServices;
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
@Table(name="shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shopId", length = 255)
    private int shopId;
//    //@Column(name = "employeeName", length = 255)
    private String shopName;
    private String shopPassword;
//   // @Column(name = "email", length = 255)
    private String shopAddress;
//    ;
//    //@Column(name = "password", length = 255)
//
    private String contactNumber;
    private String taxId;
    private String email;
    private String subscriptionPlan;
    private String activeStatus;
    private String approvedStatus;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] profileImage;

    private String openingTime;
    private String closingTime;

    @Column(name = "shop_description", length = 1000)
    private String shopDescription;
    private String shopMission;
    private double latitude;
    private double longitude;

    @JsonIgnore
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @JsonIgnore
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Payment> Payment;

    @JsonIgnore
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @JsonIgnore
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<ShopsServices> shopsServices;

    @JsonIgnore
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Repair> repairs;

    @JsonIgnore
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<ShopDetailsImages> shopDetailsImages;


}