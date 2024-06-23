package com.motorbike_reservation_system.backend.Authentication.Customer.Dto;

import com.motorbike_reservation_system.backend.Motorbike.Motorbike;
import com.motorbike_reservation_system.backend.Repair_Service.Repair;
import com.motorbike_reservation_system.backend.Reservation.Reservation;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {


    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerUsername;
    private String customerPassword;
    private String activeStatus;

}
