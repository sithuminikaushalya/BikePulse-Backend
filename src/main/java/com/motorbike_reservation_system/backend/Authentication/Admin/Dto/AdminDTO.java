package com.motorbike_reservation_system.backend.Authentication.Admin.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AdminDTO {

    private int  adminId;
    private String adminName;
    private String adminEmail;
    private String adminPassword;
    private String adminRole;
    private String activeStatus;

}

