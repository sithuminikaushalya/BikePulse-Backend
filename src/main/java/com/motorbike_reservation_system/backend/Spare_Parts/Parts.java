package com.motorbike_reservation_system.backend.Spare_Parts;

import jakarta.persistence.*;
import lombok.*;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Spare Parts")
public class Parts {

    @Id
    private String partsId;
    private String partsName;
    private String partsType;
    private String partsPrice;
    private String partsNumber;

    /////// Custom logic to generate the next available ID //////////////////////////////////////

    @PrePersist
    public void generateId() {
        if (partsId == null) {
            // Generate a random 6-digit number
            java.lang.String randomDigits = generateRandomDigits(6);

            // Assign the ID as "FM" followed by the random digits
            this.partsId = "P" + randomDigits;
        }
    }

    private java.lang.String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
