package com.motorbike_reservation_system.backend.Authentication.Shop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motorbike_reservation_system.backend.Repair_Service.Repair;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class ShopDetailsImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopDetailsImagesId;

    private String imageName;

    private String contentType;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] shopDetailsImagesData;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;


}
