package com.motorbike_reservation_system.backend.Reservation;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, String> {

    Reservation findByReservationId(String reservationId);


    @Query("SELECT r FROM Reservation r WHERE r.shop.shopId = :shopId")
    List<Reservation> findByShopId(@Param("shopId") int shopId);

    @Query("SELECT r FROM Reservation r WHERE r.customer.customerId = :customerId")
    List<Reservation> findByCustomerId(@Param("customerId") int customerId);

    @Modifying
    @Transactional
    @Query("UPDATE Reservation r SET r.approvedStatus = :approvedStatus WHERE r.reservationId = :reservationId")
    void updateApprovedStatus(@Param("reservationId") String reservationId, @Param("approvedStatus") String approvedStatus);

    @Modifying
    @Transactional
    @Query("UPDATE Reservation r SET r.processStatus = :processStatus WHERE r.reservationId = :reservationId")
    void updateProcessStatus(@Param("reservationId") String reservationId, @Param("processStatus") String processStatus);

    @Modifying
    @Transactional
    @Query("UPDATE Reservation r SET r.paymentStatus = :paymentStatus WHERE r.reservationId = :reservationId")
    void updatePaymentStatus(@Param("reservationId") String reservationId, @Param("paymentStatus") String paymentStatus);

}
