package com.motorbike_reservation_system.backend.Authentication.Customer.Dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileImageDTO {

    private int customerId;
    private byte[] profileImage;
}
