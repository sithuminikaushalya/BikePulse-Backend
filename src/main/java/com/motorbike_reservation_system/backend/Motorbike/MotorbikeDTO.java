package com.motorbike_reservation_system.backend.Motorbike;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MotorbikeDTO {
    private String motorbikeId;
    private String motorbikeName;
    private String motorbikeType;
    private String motorbikeNumber;

    private int customerId;
}
