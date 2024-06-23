package com.motorbike_reservation_system.backend.Authentication.Shop.Response;

public class ShopLoginResponse {
    int shopId;
    String message;
    Boolean status;

    public ShopLoginResponse() {
    }

    public ShopLoginResponse(int shopId, String message, Boolean status) {
        this.shopId = shopId;
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShopLoginResponse{" +
                "shopId" + shopId +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}