package com.motorbike_reservation_system.backend.Authentication.Customer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CustomerEmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendRegistrationConfirmation(String recipientEmail, String recipientCustomer) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Registration Confirmation");
        message.setText("Dear " + recipientCustomer + ",\n" +
                "\n" +
                "Welcome to Bikepulse!\n" +
                "\n" +
                "We are excited to have you on board. Your registration was successful, and you can now access our platform to book and manage your motorbike service reservations.\n" +
                "\n" +
                "If you have any questions or need further assistance, please feel free to contact us.\n" +
                "\n" +
                "Best regards,\n" +
                "Bikepulse Team");
        emailSender.send(message);
    }

    public void sendDeactivationNotification(String recipientEmail, String recipientCustomer) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Account Deactivation Notice");
        message.setText("Dear " + recipientCustomer + ",\n" +
                "\n" +
                "We regret to inform you that your account on Bikepulse has been deactivated by the admin.\n" +
                "\n" +
                "If you believe this is a mistake or if you have any questions, please contact our support team for assistance.\n" +
                "\n" +
                "Best regards,\n" +
                "Bikepulse Team");
        emailSender.send(message);
    }


}
