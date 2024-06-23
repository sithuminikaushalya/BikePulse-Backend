package com.motorbike_reservation_system.backend.Authentication.Admin.Dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileImageDTO {
    private int adminId;
    private byte[] profileImage;
}
