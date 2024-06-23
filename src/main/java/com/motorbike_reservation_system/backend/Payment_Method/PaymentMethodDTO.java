package com.motorbike_reservation_system.backend.Payment_Method;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaymentMethodDTO {
    private String paymentMethodId;
    private String paymentType;
    private String cardNumber;
    private String cardHolderName;
    private String cardExpiryDate;
    private String cvv;
    private double totalPayment;
    private String paymentId;
}
