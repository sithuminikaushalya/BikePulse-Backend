package com.motorbike_reservation_system.backend.Authentication.Admin.Entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;
    private String adminName;
    private String adminEmail;
    private String adminPassword;
    private String adminRole;
    private String activeStatus;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] profileImage;


}
