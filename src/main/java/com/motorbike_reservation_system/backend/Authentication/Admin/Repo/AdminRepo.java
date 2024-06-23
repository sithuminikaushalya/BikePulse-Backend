package com.motorbike_reservation_system.backend.Authentication.Admin.Repo;

import com.motorbike_reservation_system.backend.Authentication.Admin.Entity.Admin;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

    Optional<Admin> findOneByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);
    Admin findByAdminEmail(String adminEmail);
    Admin findByAdminId(int adminId);

    @Modifying
    @Transactional
    @Query("UPDATE Admin u SET u.activeStatus = :activeStatus WHERE u.adminId = :adminId")
    void updateActiveStatus(@Param("adminId") int adminId, @Param("activeStatus") String activeStatus);

}

