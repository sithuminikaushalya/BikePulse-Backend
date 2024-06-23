package com.motorbike_reservation_system.backend.Feedback.DTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedbackImageDTO {

    private int feedbackId;
    private byte[] feedbackImage;
}
