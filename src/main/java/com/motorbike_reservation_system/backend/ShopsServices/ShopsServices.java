package com.motorbike_reservation_system.backend.ShopsServices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.Shop;
import com.motorbike_reservation_system.backend.ServiceType.Entity.ServiceType;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "shops_services")
public class ShopsServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopsServicesId;

    @Column(name = "shop_service_name")
    private String shopServiceName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;
}
