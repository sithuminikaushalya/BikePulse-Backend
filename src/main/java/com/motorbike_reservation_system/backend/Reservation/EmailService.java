package com.motorbike_reservation_system.backend.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendReservationConfirmation(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Confirmation");
        message.setText("Thank you for your reservation! Dear "+ recipientCustomer + ",\n" +
                "\n" +
                "We are thrilled to confirm your reservation at our motorbike service station. Thank you for choosing us for your needs. We look forward to providing you with excellent service and ensuring your motorbike is in top condition.\n" +
                "\n" +
                "If you have any questions or need further assistance, please feel free to contact us.\n" +
                "\n" +
                "Best regards,\n" +
                "Bikepulse \n\n" + reservationDetails);
        emailSender.send(message);
    }

    public void sendAddReservationConfirmation(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Added");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "We are excited to inform you that your reservation has been successfully added.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "We look forward to serving you.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }

    public void sendDeleteReservationConfirmation(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Cancelled");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "We regret to inform you that your reservation has been cancelled.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "If you have any questions or need further assistance, please feel free to contact us.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }

    public void sendPendingReservationNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Pending");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "Your reservation is currently pending approval.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "We will notify you once your reservation status is updated.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }

    public void sendReservationApprovedNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Approved");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "We are pleased to inform you that your reservation has been approved.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "We look forward to serving you.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }


    public void sendReservationRejectedNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Rejected");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "We regret to inform you that your reservation has been rejected.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "If you have any questions or need further assistance, please feel free to contact us.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }





    public void sendReservationPendingNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Pending");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "Your reservation is currently pending.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "We will notify you once the status changes.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }

    public void sendReservationOnHoldNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation On Hold");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "Your reservation is currently on hold.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "We will notify you once the status changes.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }

    public void sendReservationInProgressNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation In Progress");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "Your reservation is now in progress.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "We will notify you once the service is completed.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }

    public void sendReservationCompletedNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Completed");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "Your reservation has been completed.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "Thank you for choosing Bikepulse. We hope to see you again.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }

    public void sendReservationCancelledNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Cancelled");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "Your reservation has been cancelled.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "If you have any questions, please contact us.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }

    public void sendReservationDelayedNotification(String recipientEmail, String recipientCustomer, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Reservation Delayed");
        message.setText("Dear " + recipientCustomer + ",\n\n" +
                "Your reservation has been delayed. We apologize for the inconvenience.\n\n" +
                "Reservation Details:\n" + reservationDetails + "\n\n" +
                "We will notify you once the status changes.\n\n" +
                "Best regards,\n" +
                "Bikepulse");
        emailSender.send(message);
    }


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
