package com.motorbike_reservation_system.backend.payment;


import com.motorbike_reservation_system.backend.Authentication.Customer.Repo.CustomerRepo;
import com.motorbike_reservation_system.backend.Authentication.Shop.Repo.ShopRepo;
import com.motorbike_reservation_system.backend.Payment_Method.PaymentMethodRepo;
import com.motorbike_reservation_system.backend.Repair_Service.Repair;
import com.motorbike_reservation_system.backend.Repair_Service.RepairRepo;
import com.motorbike_reservation_system.backend.Reservation.EmailService;
import com.motorbike_reservation_system.backend.Reservation.Reservation;
import com.motorbike_reservation_system.backend.Reservation.ReservationDetailsDTO;
import com.motorbike_reservation_system.backend.Reservation.ReservationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ReservationRepo reservationRepo;
    @Autowired
    private PaymentEmailService paymentEmailService;

    @Autowired
    private RepairRepo repairRepo;

    @Autowired
    private PaymentMethodRepo paymentMethodRepo;


    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }


    public List<Payment> getPayment() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentByPaymentId(String paymentId) {
        return paymentRepository.findByPaymentId(paymentId);
    }

    public String deletePayment(String paymentId) {
        paymentRepository.deleteById(paymentId);
        return "Payment " + paymentId + "  removed successfully !! " ;
    }

    public Payment updatePayment(Payment payment) {
        Payment existingPayment = paymentRepository.findByPaymentId(payment.getPaymentId());
        existingPayment.setTotalPayment(payment.getTotalPayment());
        existingPayment.setPaymentType(payment.getPaymentType());
        existingPayment.setPaymentMethod(payment.getPaymentMethod());
        return paymentRepository.save(existingPayment);
    }

    public Payment addPayment(PaymentDTO paymentDTO) {
        Payment payment = Payment.builder()
                .totalPayment(paymentDTO.getTotalPayment())
                .paymentType(paymentDTO.getPaymentType())
                .paymentDate(paymentDTO.getPaymentDate())
                .paymentTime(paymentDTO.getPaymentTime())
                .repair(repairRepo.findByServiceId(paymentDTO.getServiceId()))
                .reservation(reservationRepo.findByReservationId(paymentDTO.getReservationId()))
                .paymentMethod(paymentMethodRepo.findByPaymentMethodId(paymentDTO.getPaymentMethodId()))
                .customer(customerRepo.findByCustomerId(paymentDTO.getCustomerId()))
                .shop(shopRepo.findByShopId(paymentDTO.getShopId()))
                .build();
        return paymentRepository.save(payment);
    }

    public List<PaymentDetailsDTO> getAllPaymentDetails() {
        List<Payment> payments = getPayment();
        return payments.stream()
                .map(payment -> new PaymentDetailsDTO(
                        payment.getPaymentId(),
                        payment.getTotalPayment(),
                        payment.getPaymentType(),
                        convertToSqlDate(payment.getPaymentDate()),
                        payment.getPaymentTime(),
                        payment.getPaymentStatus(),
                        (payment.getReservation() != null) ? payment.getReservation().getReservationId(): null,
                        (payment.getReservation() != null) ? payment.getReservation().getServiceType() : null,
                        (payment.getCustomer() != null) ? payment.getCustomer().getCustomerName() : null,
                        (payment.getShop() != null) ? payment.getShop().getShopName() : null


                ))
                .collect(Collectors.toList());
    }

    private Date convertToSqlDate(java.util.Date date) {
        if (date != null) {
            return new Date(date.getTime());
        }
        return null;
    }


    @Transactional
    public void updatePaymentStatus(String paymentId, String paymentStatus) {
        paymentRepository.updatePaymentStatuses(paymentId, paymentStatus);

        // Get the reservation details
        Payment payment = paymentRepository.findById(paymentId).orElse(null);
        if (payment == null) {
            return; // Handle the case where reservation is not found
        }

        String recipientEmail = payment.getCustomer().getCustomerEmail();
        String recipientCustomer = payment.getCustomer().getCustomerName();
        String reservationDetails = buildPaymentDetails(payment); // Create payment details string

        // Send notification based on payment status
        switch (paymentStatus) {
            case "pending":
                paymentEmailService.sendReservationPaymentPendingNotification(recipientEmail, recipientCustomer, reservationDetails);
                break;
            case "completed":
                paymentEmailService.sendReservationPaymentCompletedNotification(recipientEmail, recipientCustomer, reservationDetails);
                break;
            default:
                // Handle invalid payment status
                break;
        }
    }

    private String buildPaymentDetails(Payment payment) {
        return "Payment Details:\n" +
                "Payment ID: " + payment.getPaymentId() + "\n" +
                "Total Payment: " + payment.getTotalPayment() + "\n" +
                "Payment Type: " + payment.getPaymentType() + "\n" +
                "Payment Date: " + payment.getPaymentDate() + "\n" +
                "Payment Time: " + payment.getPaymentTime() + "\n";
    }



}