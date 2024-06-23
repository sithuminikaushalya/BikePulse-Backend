package com.motorbike_reservation_system.backend.payment;


import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Time;

@Builder
@Getter
public class PaymentDTO {

    private String paymentId;
    private String totalPayment;
    private String paymentType;
    private Date paymentDate;
    private Time paymentTime;
    private String paymentStatus;
    private String serviceId;
    private String reservationId;
    private String paymentMethodId;
    private int shopId;
    private int customerId;
}
