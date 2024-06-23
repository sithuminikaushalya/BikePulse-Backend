package com.motorbike_reservation_system.backend.Repair_Service;

import com.motorbike_reservation_system.backend.Motorbike.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepo extends JpaRepository<Repair,String> {
    Repair findByServiceId(String repairServiceId);


}