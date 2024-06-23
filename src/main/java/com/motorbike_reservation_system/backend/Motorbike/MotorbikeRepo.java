package com.motorbike_reservation_system.backend.Motorbike;

import com.motorbike_reservation_system.backend.Fault_Management.Fault;
import com.motorbike_reservation_system.backend.Spare_Parts.Parts;
import com.motorbike_reservation_system.backend.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorbikeRepo extends JpaRepository<Motorbike,String> {
    Motorbike findByMotorbikeNumber(String motorbikeNumber);

    Motorbike findByMotorbikeId(String motorbikeId);
}
