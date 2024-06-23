package com.motorbike_reservation_system.backend.Authentication.Shop.Dto;


import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ShopDTO {

    private int  shopId;
    private String shopName;
    private String shopPassword;
    private String shopAddress;
    private String contactNumber;
    private String taxId;
    private String email;
    private String subscriptionPlan;
    private String activeStatus;
    private String approvedStatus;

}