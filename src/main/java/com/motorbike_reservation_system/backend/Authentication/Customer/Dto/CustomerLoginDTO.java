package com.motorbike_reservation_system.backend.Authentication.Customer.Dto;

public class CustomerLoginDTO {
    private String customerEmail;
    private String customerPassword;

    public CustomerLoginDTO() {
    }

    public CustomerLoginDTO(String customerEmail, String customerPassword) {
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
    }

    @Override
    public String toString() {
        return "CustomerLoginDTO{" +
                "customerEmail='" + customerEmail + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                '}';
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
}
