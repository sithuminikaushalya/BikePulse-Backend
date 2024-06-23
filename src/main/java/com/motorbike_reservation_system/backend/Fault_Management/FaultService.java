package com.motorbike_reservation_system.backend.Fault_Management;

import com.motorbike_reservation_system.backend.Reservation.Reservation;
import com.motorbike_reservation_system.backend.Reservation.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaultService {

    @Autowired
    private FaultRepository faultRepository;
    @Autowired
    private ReservationRepo reservationRepo;

    public Fault saveFault(Fault fault) {
        return faultRepository.save(fault);
    }

    public List<Fault> getFault() {
        return faultRepository.findAll();
    }

//    public Product getProductById(int id) {
//        return repository.findById(id).orElse(null);
//    }

    public Fault getFaultByFaultName(String faultName) {
        return faultRepository.findByFaultName(faultName);
    }

    public String deleteFault(String faultId){
        faultRepository.deleteById(faultId);
        return "product removed !! " + faultId;
    }

    public Fault updateFault(Fault fault) {
        Fault existingFault = faultRepository.findByFaultName(fault.getFaultName());
        existingFault.setFaultName(fault.getFaultName());
//        existingProduct.setQuantity(product.getQuantity());
//        existingProduct.setPrice(product.getPrice());
        return faultRepository.save(existingFault);
    }

    public Fault addFault(FaultDTO addFaultRequest) {
        Reservation reservation = reservationRepo.findByReservationId(addFaultRequest.getReservationId());
        Fault fault = Fault.builder()
                .motorbikeNumber(addFaultRequest.getMotorbikeNumber())
                .category(addFaultRequest.getCategory())
                .faultDescription(addFaultRequest.getFaultDescription())
                .motorbikeName(addFaultRequest.getMotorbikeName())
                .motorbikeType(addFaultRequest.getMotorbikeType())
                .faultName(addFaultRequest.getFaultName())
                .reservation(reservation)
                .build();

        return faultRepository.save(fault);
    }
}
