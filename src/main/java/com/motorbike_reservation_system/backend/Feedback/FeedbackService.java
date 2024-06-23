package com.motorbike_reservation_system.backend.Feedback;

import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.Customer;
import com.motorbike_reservation_system.backend.Authentication.Customer.Repo.CustomerRepo;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.Shop;
import com.motorbike_reservation_system.backend.Authentication.Shop.Repo.ShopRepo;
import com.motorbike_reservation_system.backend.Feedback.DTO.FeedbackDTO;
import com.motorbike_reservation_system.backend.Feedback.DTO.FeedbackDetailsDTO;
import com.motorbike_reservation_system.backend.Repair_Service.Repair;
import com.motorbike_reservation_system.backend.Repair_Service.RepairRepo;
import com.motorbike_reservation_system.backend.Reservation.Reservation;
import com.motorbike_reservation_system.backend.Reservation.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepo feedbackRepo;
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private RepairRepo repairRepo;
    @Autowired
    private ReservationRepo reservationRepo;

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    public List<Feedback> getFeedback() {
        return feedbackRepo.findAll();
    }

    public Feedback getFeedbackById(int feedbackId) {
        return feedbackRepo.findByFeedbackId(feedbackId);

    }

    public List<Feedback> getFeedbacks(String comment){
        return feedbackRepo.findByComment(comment);
    }

    public String deleteFeedback(int feedbackId){
        feedbackRepo.deleteById(feedbackId);
        return "product removed !! " + feedbackId;
    }

    public Feedback updateFeedback(Feedback feedback) {
        Feedback existingFeedback = feedbackRepo.findById(feedback.getFeedbackId()).orElse(null);
       // existingFeedback.setFeedback(feedback.getFeedback());
//        existingProduct.setQuantity(product.getQuantity());
//        existingProduct.setPrice(product.getPrice());
        return feedbackRepo.save(existingFeedback);
    }

//    public Feedback addFeedback(FeedbackDTO addFeedbackRequest) {
//        Shop shop = shopRepo.findByShopId(addFeedbackRequest.getShopId());
//        Customer customer = customerRepo.findByCustomerId(addFeedbackRequest.getCustomerId());
//        Repair repair = repairRepo.findByServiceId(addFeedbackRequest.getServiceId());
//        Reservation reservation = reservationRepo.findByReservationId(addFeedbackRequest.getReservationId());
//        Feedback feedback = Feedback.builder()
//                .rating(addFeedbackRequest.getRating())
//                .comment(addFeedbackRequest.getComment())
//                .shop(shop)
//                .customer(customer)
//                .repair(repair)
//                .reservation(reservation)
//                .build();
//        return feedbackRepo.save(feedback);
//    }

    public Feedback addFeedback(FeedbackDTO addFeedbackRequest, MultipartFile feedbackImage) throws IOException {
        Shop shop = shopRepo.findByShopId(addFeedbackRequest.getShopId());
        Customer customer = customerRepo.findByCustomerId(addFeedbackRequest.getCustomerId());
        Repair repair = repairRepo.findByServiceId(addFeedbackRequest.getServiceId());
        Reservation reservation = reservationRepo.findByReservationId(addFeedbackRequest.getReservationId());

        Feedback feedback = Feedback.builder()
                //.feedbackId(addFeedbackRequest.getFeedbackId())
                .rating(addFeedbackRequest.getRating())
                .comment(addFeedbackRequest.getComment())
                .shop(shop)
                .customer(customer)
                .repair(repair)
                .reservation(reservation)
                .feedbackImage(feedbackImage.getBytes())
                .build();
        return feedbackRepo.save(feedback);
    }

    public FeedbackDetailsDTO convertToDTO(Feedback feedback) {
        return FeedbackDetailsDTO.builder()
                .feedbackId(feedback.getFeedbackId())
                .rating(feedback.getRating())
                .comment(feedback.getComment())
                .feedbackImage(feedback.getFeedbackImage())
                .customerName(feedback.getCustomer() != null ? feedback.getCustomer().getCustomerName() : null)
                .shopName(feedback.getShop() != null ? feedback.getShop().getShopName() : null)
                .serviceType(feedback.getReservation() != null ? feedback.getReservation().getServiceType() : null)
                .build();
    }

    // get feedback by shop id

    public List<Feedback> getFeedbackByShopId(int shopId) {
        return feedbackRepo.findByShop_ShopId(shopId);
    }

    public List<FeedbackDetailsDTO> getFeedbackDetailsByShopId(int shopId) {
        return getFeedbackByShopId(shopId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


}
