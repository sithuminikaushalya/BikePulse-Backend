package com.motorbike_reservation_system.backend.Fault_Management;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FaultDTO {
    private String faultName;
    private String motorbikeName;
    private String motorbikeType;
    private String motorbikeNumber;
    private String category;
    private String faultDescription;
    private String reservationId;
}
