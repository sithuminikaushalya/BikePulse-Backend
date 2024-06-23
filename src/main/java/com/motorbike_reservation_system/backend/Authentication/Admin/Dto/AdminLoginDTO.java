package com.motorbike_reservation_system.backend.Authentication.Admin.Dto;

public class AdminLoginDTO {

    private String adminEmail;
    private String adminPassword;

    public AdminLoginDTO() {
    }

    public AdminLoginDTO(String adminEmail, String adminPassword) {
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "AdminLoginDTO{" +
                "adminEmail='" + adminEmail + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

}
