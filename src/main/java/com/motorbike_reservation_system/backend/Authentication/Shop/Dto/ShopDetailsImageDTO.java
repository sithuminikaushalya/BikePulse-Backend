package com.motorbike_reservation_system.backend.Authentication.Shop.Dto;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ShopDetailsImageDTO {

    private int shopDetailsImagesId;
    private String imageName;
    private String contentType;
    private byte[] shopDetailsImagesData;
    private int shopId;

}
