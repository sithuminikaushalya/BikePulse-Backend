package com.motorbike_reservation_system.backend.Authentication.Admin.Controller;

import com.motorbike_reservation_system.backend.Authentication.Admin.Dto.AdminDTO;
import com.motorbike_reservation_system.backend.Authentication.Admin.Dto.AdminLoginDTO;
import com.motorbike_reservation_system.backend.Authentication.Admin.Dto.ProfileImageDTO;
import com.motorbike_reservation_system.backend.Authentication.Admin.Entity.Admin;
import com.motorbike_reservation_system.backend.Authentication.Admin.Response.AdminLoginResponse;
import com.motorbike_reservation_system.backend.Authentication.Admin.Service.AdminService;
import com.motorbike_reservation_system.backend.Authentication.Admin.Service.Impl.AdminIMPL;
import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.Customer;
import com.motorbike_reservation_system.backend.Reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminIMPL adminIMPL;


    @PostMapping(path= "/save")
    public String saveAdmin(@RequestBody AdminDTO adminDTO){
        return adminService.addAdmin(adminDTO);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO){
        AdminLoginResponse adminLoginResponse = adminService.loginAdmin(adminLoginDTO);
        return ResponseEntity.ok(adminLoginResponse);
    }


    @GetMapping("/getAdmin")
    public List<Admin> findAllAdmin() {
        return adminIMPL.getAdmin();
    }

    @PutMapping("/{adminId}/active-status")
    public void updateActiveStatus(@PathVariable int adminId, @RequestParam String activeStatus) {
        adminIMPL.updateActiveStatus(adminId, activeStatus);
    }

    @GetMapping("/{adminId}")
    public Admin getCustomerById(@PathVariable int adminId) {
        return adminIMPL.getAdminById(adminId);
    }

    // profile image
    @GetMapping("/{adminId}/profile-image")
    public ResponseEntity<ProfileImageDTO> getProfileImage(@PathVariable int adminId) {
        ProfileImageDTO profileImageDTO = adminIMPL.getProfileImageById(adminId);
        return ResponseEntity.ok(profileImageDTO);
    }

    @DeleteMapping("/{adminId}/profile-image")
    public ResponseEntity<Void> deleteProfileImage(@PathVariable int adminId) {
        adminIMPL.deleteProfileImage(adminId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{adminId}/profile-image")
    public ResponseEntity<ProfileImageDTO> updateProfileImage(
            @PathVariable int adminId,
            @RequestBody ProfileImageDTO profileImageDTO) {
        profileImageDTO.setAdminId(adminId);
        ProfileImageDTO updatedProfileImage = adminIMPL.updateProfileImage(profileImageDTO);
        return ResponseEntity.ok(updatedProfileImage);
    }
}
