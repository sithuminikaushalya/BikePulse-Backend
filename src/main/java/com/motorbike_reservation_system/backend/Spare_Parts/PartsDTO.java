package com.motorbike_reservation_system.backend.Spare_Parts;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PartsDTO {
    private String partsId;
    private String partsName;
    private String partsType;
    private String partsPrice;
    private String partsNumber;
}
