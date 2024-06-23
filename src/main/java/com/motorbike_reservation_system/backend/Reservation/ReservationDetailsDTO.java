package com.motorbike_reservation_system.backend.Reservation;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;



@Builder
@Getter
public class ReservationDetailsDTO {
    
    private String reservationId;
    private String motorbikeNumber;
    private String serviceType;
    private Date reservationDate;
    private Time reservationTime;
    private String reservationAddress;
    private String approvedStatus;
    private String processStatus;
    private String paymentStatus;
    private String customerName;
    private String customerPhoneNumber;
    private String customerEmail;
    private String shopName;
    private String email;  //shop
    private String contactNumber;  //shop
}
