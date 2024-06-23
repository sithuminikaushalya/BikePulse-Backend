package com.motorbike_reservation_system.backend.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PaymentEmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendReservationPaymentPendingNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Payment Pending");
        message.setText("Dear " + recipientCustomer + ",\n" +
                "\n" +
                "Your reservation payment is pending. Please complete the payment to confirm your reservation.\n" +
                "\n" +
                "Reservation Details:\n" + reservationDetails +
                "\n" +
                "If you have any questions or need further assistance, please feel free to contact us.\n" +
                "\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }

    public void sendReservationPaymentCompletedNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Payment Completed");
        message.setText("Dear " + recipientCustomer + ",\n" +
                "\n" +
                "Your reservation payment has been completed successfully. Your reservation is confirmed.\n" +
                "\n" +
                "Reservation Details:\n" + reservationDetails +
                "\n" +
                "If you have any questions or need further assistance, please feel free to contact us.\n" +
                "\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }
}
