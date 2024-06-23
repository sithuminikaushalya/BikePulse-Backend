package com.motorbike_reservation_system.backend.Feedback.DTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedbackDetailsDTO {

    private int feedbackId;
    private String rating;
    private String comment;
    private byte[] feedbackImage;
    private String shopName;
    private String customerName;
    private String serviceType;

}
