package com.motorbike_reservation_system.backend.Fault_Management;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motorbike_reservation_system.backend.Reservation.Reservation;
import jakarta.persistence.*;
import lombok.*;

import java.util.Random;

@Entity
@Table(name = "fault")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Fault {

    @Id
    private java.lang.String faultId;
    private java.lang.String faultName;
    private java.lang.String motorbikeName;
    private java.lang.String motorbikeType;
    private java.lang.String motorbikeNumber;
    private java.lang.String category;
    private java.lang.String faultDescription;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "reservationId", referencedColumnName = "reservationId")
//    private Reservation reservation;
    @JsonIgnore
    @OneToOne(mappedBy = "fault")
    private Reservation reservation;




    /////// Custom logic to generate the next available ID //////////////////////////////////////

    @PrePersist
    public void generateId() {
        if (faultId == null) {
            // Generate a random 6-digit number
            java.lang.String randomDigits = generateRandomDigits(6);

            // Assign the ID as "FM" followed by the random digits
            this.faultId = "FM" + randomDigits;
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
