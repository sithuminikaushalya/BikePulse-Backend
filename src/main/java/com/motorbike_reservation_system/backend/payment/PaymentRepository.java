package com.motorbike_reservation_system.backend.payment;

import com.motorbike_reservation_system.backend.Motorbike.Motorbike;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,String> {
    Payment findByPaymentId(String paymentId);


//    @Modifying
//    @Transactional
//    @Query("UPDATE Reservation u SET u.paymentStatus = :paymentStatus WHERE u.paymentId = :paymentId")
//    void updatePaymentStatus(@Param("paymentId") String paymentId, @Param("paymentStatus") String paymentStatus);

    @Modifying
    @Transactional
    @Query("UPDATE Payment r SET r.paymentStatus = :paymentStatus WHERE r.paymentId = :paymentId")
    void updatePaymentStatuses(@Param("paymentId") String paymentId, @Param("paymentStatus") String paymentStatus);

}
