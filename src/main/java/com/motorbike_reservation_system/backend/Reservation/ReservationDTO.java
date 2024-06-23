package com.motorbike_reservation_system.backend.Reservation;

import lombok.Builder;
import lombok.Getter;

import java.sql.Time;
import java.util.Date;

@Builder
@Getter
public class ReservationDTO {

    private String reservationId;
    private String motorbikeNumber;
    private String serviceType;
    private Date reservationDate;
    private Time reservationTime;
    private String reservationAddress;
    private String approvedStatus;
    private String processStatus;
    private String paymentStatus;
    private int shopId;
    private int customerId;
    private String customerEmail;
    private String  serviceId;
    private String faultId;
}
