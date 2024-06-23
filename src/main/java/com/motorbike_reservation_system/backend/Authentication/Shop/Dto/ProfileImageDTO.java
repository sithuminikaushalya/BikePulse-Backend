package com.motorbike_reservation_system.backend.Authentication.Shop.Dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileImageDTO {
    private int shopId;
    private byte[] profileImage;
}
