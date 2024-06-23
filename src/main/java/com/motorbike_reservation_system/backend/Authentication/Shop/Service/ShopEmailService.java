package com.motorbike_reservation_system.backend.Authentication.Shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ShopEmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendShopRegistrationConfirmation(String recipientEmail, String shopName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Shop Registration Confirmation");
        message.setText("Dear " + shopName + ",\n" +
                "\n" +
                "Thank you for registering your shop with Bikepulse! Your shop is now registered and pending approval. We are thrilled to have you on board and look forward to a fruitful collaboration.\n" +
                "\n" +
                "If you have any questions or need further assistance, please feel free to contact us.\n" +
                "\n" +
                "Best regards,\n" +
                "Bikepulse Team");
        emailSender.send(message);
    }

    public void sendShopDeactivationNotification(String recipientEmail, String shopName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Shop Deactivation Notice");
        message.setText("Dear " + shopName + ",\n" +
                "\n" +
                "We regret to inform you that your shop has been deactivated by the admin. You will no longer be able to access certain features until your shop is reactivated.\n" +
                "\n" +
                "If you have any questions or need further assistance, please contact us.\n" +
                "\n" +
                "Best regards,\n" +
                "Bikepulse Team");
        emailSender.send(message);
    }

    public void sendShopApprovedNotification(String recipientEmail, String shopName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Shop Approval Notice");
        message.setText("Dear " + shopName + ",\n" +
                "\n" +
                "Congratulations! Your shop has been approved by the admin. You can now access all the features of our platform.\n" +
                "\n" +
                "If you have any questions or need further assistance, please contact us.\n" +
                "\n" +
                "Best regards,\n" +
                "Bikepulse Team");
        emailSender.send(message);
    }

    public void sendShopRejectedNotification(String recipientEmail, String shopName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Shop Rejection Notice");
        message.setText("Dear " + shopName + ",\n" +
                "\n" +
                "We regret to inform you that your shop has been rejected by the admin. Please review the application criteria and try again.\n" +
                "\n" +
                "If you have any questions or need further assistance, please contact us.\n" +
                "\n" +
                "Best regards,\n" +
                "Bikepulse Team");
        emailSender.send(message);
    }

    public void sendShopPendingNotification(String recipientEmail, String shopName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Shop Approval Pending");
        message.setText("Dear " + shopName + ",\n" +
                "\n" +
                "Your shop application is currently under review. We will notify you once the review process is complete.\n" +
                "\n" +
                "If you have any questions or need further assistance, please contact us.\n" +
                "\n" +
                "Best regards,\n" +
                "Bikepulse Team");
        emailSender.send(message);
    }

}
