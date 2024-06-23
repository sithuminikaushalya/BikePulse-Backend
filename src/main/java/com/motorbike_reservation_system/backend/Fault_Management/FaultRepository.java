package com.motorbike_reservation_system.backend.Fault_Management;


import org.springframework.data.jpa.repository.JpaRepository;

public interface FaultRepository extends JpaRepository<Fault,String> {
    Fault findByFaultName(String faultName);
    Fault findByFaultId(String faultId);
}