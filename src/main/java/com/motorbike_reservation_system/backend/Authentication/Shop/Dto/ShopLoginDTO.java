package com.motorbike_reservation_system.backend.Authentication.Shop.Dto;

public class ShopLoginDTO {
    private String email;
    private String shopPassword;

    public ShopLoginDTO() {
    }

    public ShopLoginDTO(String Email, String shopPassword) {
        this.email = Email;
        this.shopPassword = shopPassword;
    }

    @Override
    public String toString() {
        return "ShopLoginDTO{" +
                "Email='" + email + '\'' +
                ", shopPassword='" + shopPassword + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getShopPassword() {
        return shopPassword;
    }

    public void setShopPassword(String shopPassword) {
        this.shopPassword = shopPassword;
    }


}