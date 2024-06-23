package com.motorbike_reservation_system.backend.Authentication.Shop.Dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ShopPasswordDTO {
    private int shopId;
    private String shopPassword;
}
