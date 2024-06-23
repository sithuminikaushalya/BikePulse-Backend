package com.motorbike_reservation_system.backend.Feedback;

import com.motorbike_reservation_system.backend.Fault_Management.Fault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,Integer> {
    List<Feedback> findByComment(String comment);
    Feedback findByFeedbackId(int FeedbackId);

    List<Feedback> findByShop_ShopId(int shopId);
}
