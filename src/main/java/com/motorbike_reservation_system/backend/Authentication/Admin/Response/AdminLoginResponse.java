package com.motorbike_reservation_system.backend.Authentication.Admin.Response;

public class AdminLoginResponse {
    String message;
    Boolean status;

    public AdminLoginResponse() {
    }

    public AdminLoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdminLoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
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
