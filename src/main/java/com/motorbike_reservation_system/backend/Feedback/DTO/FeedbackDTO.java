package com.motorbike_reservation_system.backend.Feedback.DTO;



import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeedbackDTO {

    // private int feedbackId;
    private String rating;
    private String comment;
    private byte[] feedbackImage;
    private int shopId;
    private int customerId;
    private String serviceId;
    private String reservationId;
}
