package com.motorbike_reservation_system.backend.Payment_Method;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.motorbike_reservation_system.backend.Reservation.Reservation;
import com.motorbike_reservation_system.backend.payment.Payment;
import jakarta.persistence.*;
import lombok.*;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Payment_Method")
public class PaymentMethod {

    @Id
    private String paymentMethodId;
    private String paymentType;
    private String cardNumber;
    private String cardHolderName;

    private String cardExpiryDate;
    private String cvv;
    private double totalPayment;


//    @OneToOne(mappedBy = "paymentMethod",
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private Payment payment;

    @JsonIgnore
    @OneToOne(mappedBy = "paymentMethod")
    private Payment payment;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "payment", referencedColumnName = "paymentId")
//    private Payment payment;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "payment_method_id")
//    private PaymentMethod paymentMethod;

//    public PaymentMethod() {
//    }
//
//    public PaymentMethod(String paymentMethodId, String paymentType, String cardNumber, String cardHolderName, String cardExpiryDate, String cvv, double totalPayment, Payment payment) {
//        this.paymentMethodId = paymentMethodId;
//        this.paymentType = paymentType;
//        this.cardNumber = cardNumber;
//        this.cardHolderName = cardHolderName;
//        this.cardExpiryDate = cardExpiryDate;
//        this.cvv = cvv;
//        this.totalPayment = totalPayment;
//        this.payment = payment;
//    }
//
//    public PaymentMethod(String paymentType, String cardNumber, String cardHolderName, String cardExpiryDate, String cvv, double totalPayment, Payment payment) {
//        this.paymentType = paymentType;
//        this.cardNumber = cardNumber;
//        this.cardHolderName = cardHolderName;
//        this.cardExpiryDate = cardExpiryDate;
//        this.cvv = cvv;
//        this.totalPayment = totalPayment;
//        this.payment = payment;
//    }
//
//    public String getPaymentMethodId() {
//        return paymentMethodId;
//    }
//
//    public void setPaymentMethodId(String paymentMethodId) {
//        this.paymentMethodId = paymentMethodId;
//    }
//
//    public String getPaymentType() {
//        return paymentType;
//    }
//
//    public void setPaymentType(String paymentType) {
//        this.paymentType = paymentType;
//    }
//
//    public String getCardNumber() {
//        return cardNumber;
//    }
//
//    public void setCardNumber(String cardNumber) {
//        this.cardNumber = cardNumber;
//    }
//
//    public String getCardHolderName() {
//        return cardHolderName;
//    }
//
//    public void setCardHolderName(String cardHolderName) {
//        this.cardHolderName = cardHolderName;
//    }
//
//    public String getCardExpiryDate() {
//        return cardExpiryDate;
//    }
//
//    public void setCardExpiryDate(String cardExpiryDate) {
//        this.cardExpiryDate = cardExpiryDate;
//    }
//
//    public String getCvv() {
//        return cvv;
//    }
//
//    public void setCvv(String cvv) {
//        this.cvv = cvv;
//    }
//
//    public double getTotalPayment() {
//        return totalPayment;
//    }
//
//    public void setTotalPayment(double totalPayment) {
//        this.totalPayment = totalPayment;
//    }
//
//    public Payment getPayment() {
//        return payment;
//    }
//
//    public void setPayment(Payment payment) {
//        this.payment = payment;
//    }
//
//    public PaymentMethod getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(PaymentMethod paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }



    /////// Custom logic to generate the next available ID //////////////////////////////////////

    @PrePersist
    public void generateId() {
        if (paymentMethodId == null) {
            // Generate a random 6-digit number
            String randomDigits = generateRandomDigits(6);

            // Assign the ID as "FM" followed by the random digits
            this.paymentMethodId = "PM" + randomDigits;
        }
    }

    private String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
