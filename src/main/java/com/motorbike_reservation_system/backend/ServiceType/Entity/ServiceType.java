package com.motorbike_reservation_system.backend.ServiceType.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motorbike_reservation_system.backend.ShopsServices.ShopsServices;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "service_type")
public class ServiceType {

    @Id
    @Column(name = "service_type_id")
    private String serviceTypeId;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "service_type_description")
    private String serviceTypeDescription;

    @Lob
    @Column(name = "service_type_image", columnDefinition = "LONGBLOB")
    private byte[] serviceTypeImage;

    @JsonIgnore
    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private List<ShopsServices> shopsServices;

    @PrePersist
    public void generateId() {
        if (serviceTypeId == null) {
            String randomDigits = generateRandomDigits(6);
            this.serviceTypeId = "ST" + randomDigits;
        }
    }

    private String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
