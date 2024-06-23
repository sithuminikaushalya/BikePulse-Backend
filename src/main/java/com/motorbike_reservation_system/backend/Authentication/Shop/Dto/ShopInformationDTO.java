package com.motorbike_reservation_system.backend.Authentication.Shop.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ShopInformationDTO {

    private int shopId;
    private String openingTime;
    private String closingTime;
    private String shopDescription;
    private String shopMission;
    private double latitude;
    private double longitude;
}
