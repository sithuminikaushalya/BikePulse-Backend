package com.motorbike_reservation_system.backend.Repair_Service;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Builder
@Getter
public class RepairDTO {

    private String serviceId;
    private Time serviceTime;
    private Date serviceDate;
    private String serviceStatus;
    private String serviceCategory;
    private String partsNumber;
    private int customerId;
    private int shopId;
    private String reservationId;
    private int feedbackId;
    private String paymentId;

}
