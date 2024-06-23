package com.motorbike_reservation_system.backend.payment;


import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Builder
@Getter
public class PaymentDetailsDTO {

    private String paymentId;
    private String totalPayment;
    private String paymentType;
    private Date paymentDate;
    private Time paymentTime;
    private String paymentStatus;
    private String reservationId;
    private String serviceType;
    //private String paymentMethodId;
    private String shopName;
    private String customerName;
}
