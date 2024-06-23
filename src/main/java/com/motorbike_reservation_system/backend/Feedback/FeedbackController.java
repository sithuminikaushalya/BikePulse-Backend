package com.motorbike_reservation_system.backend.Feedback;

import com.motorbike_reservation_system.backend.Feedback.DTO.FeedbackDTO;
import com.motorbike_reservation_system.backend.Feedback.DTO.FeedbackDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

//    @PostMapping("/addfeedback")
//    public ResponseEntity<Integer> addFeedback(@RequestBody FeedbackDTO feedbackDTO) {
//        int feedbackId = feedbackService.addFeedback(feedbackDTO).getFeedbackId();
//        return ResponseEntity.ok(feedbackId);
//    }

    @PostMapping("/addfeedback")
    public ResponseEntity<String> addFeedbackWithImage(@ModelAttribute FeedbackDTO feedbackDTO,
                                                       @RequestParam("image") MultipartFile image) {
        try {
            Feedback feedback = feedbackService.addFeedback(feedbackDTO, image);
            return new ResponseEntity<>("Feedback added successfully with ID: " + feedback.getFeedbackId(), HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to add feedback: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getfeedback")
    public List<Feedback> findAllFeedbacks() {
        return feedbackService.getFeedback();
    }

    @GetMapping("/feedback/{feedbackId}")
    public List<Feedback> findFeedbacks(@PathVariable String comment) {
        return feedbackService.getFeedbacks(comment);
    }

    @PutMapping("/updatefeedback")
    public Feedback updateFeedback(@RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(feedback);
    }

    @DeleteMapping("/deletefeedback/{feedbackId}")
    public String deleteFeedback(@PathVariable int feedbackId) {
        return feedbackService.deleteFeedback(feedbackId);
    }

    @GetMapping("/feedbackDetails")
    public ResponseEntity<List<FeedbackDetailsDTO>> getAllFeedbacks() {
        List<Feedback> feedbackList = feedbackService.getFeedback();
        if (feedbackList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<FeedbackDetailsDTO> feedbackDTOList = feedbackList.stream()
                .map(feedbackService::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(feedbackDTOList, HttpStatus.OK);
    }

    // Endpoint to get feedback details by ID
    @GetMapping("/{feedbackId}")
    public ResponseEntity<FeedbackDetailsDTO> getFeedbackDetails(@PathVariable int feedbackId) {
        Feedback feedback = feedbackService.getFeedbackById(feedbackId);
        if (feedback == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        FeedbackDetailsDTO feedbackDetailsDTO = feedbackService.convertToDTO(feedback);
        return new ResponseEntity<>(feedbackDetailsDTO, HttpStatus.OK);
    }


    // Endpoint to get feedback details by shop ID
    @GetMapping("/shopId/{shopId}")
    public ResponseEntity<List<FeedbackDetailsDTO>> getFeedbacksByShopId(@PathVariable int shopId) {
        List<FeedbackDetailsDTO> feedbackDetailsList = feedbackService.getFeedbackDetailsByShopId(shopId);
        if (feedbackDetailsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(feedbackDetailsList, HttpStatus.OK);
    }
}