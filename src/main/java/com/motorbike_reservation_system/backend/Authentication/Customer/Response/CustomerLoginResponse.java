package com.motorbike_reservation_system.backend.Authentication.Customer.Response;

public class CustomerLoginResponse {
    int customerId;
    String message;
    Boolean status;

    public CustomerLoginResponse() {
    }

    public CustomerLoginResponse(int customerId, String message, Boolean status) {
        this.customerId = customerId;
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerLoginResponse{" +
                "customerId" + customerId +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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