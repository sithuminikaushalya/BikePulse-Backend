package com.motorbike_reservation_system.backend.Motorbike;


import com.motorbike_reservation_system.backend.Authentication.Customer.Repo.CustomerRepo;
import com.motorbike_reservation_system.backend.Motorbike.Motorbike;
import com.motorbike_reservation_system.backend.Motorbike.MotorbikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorbikeService {
    @Autowired
    private MotorbikeRepo motorbikeRepo;

    @Autowired
    private CustomerRepo customerRepo;

    public Motorbike saveMotorbike(Motorbike motorbike) {
        return motorbikeRepo.save(motorbike);
    }

//    public Motorbike saveMotorbike(Motorbike motorbike) {
//        return motorbikeRepo.save(motorbike);
//    }

//    public List<Motorbike> saveMotorbike(List<Motorbike> motorbike) {
//        return motorbikeRepo.saveAll(motorbike);
//    }

    public List<Motorbike> getMotorbike() {
        return motorbikeRepo.findAll();
    }

    public Motorbike getMotorbikeByMotorbikeId(String motorbikeId) {
        return motorbikeRepo.findByMotorbikeId(motorbikeId);
    }

    public Motorbike getMotorbikeByMotorbikeNumber(String motorbikeNumber) {
        return motorbikeRepo.findByMotorbikeNumber(motorbikeNumber);
    }

    public String deleteMotorbike(String motorbikeId) {
        motorbikeRepo.deleteById(motorbikeId);
        return "Motorbike " + motorbikeId + " removed !! " ;
    }

    public Motorbike updateMotorbike(Motorbike motorbike) {
        Motorbike existingMotorbike = motorbikeRepo.findByMotorbikeId(motorbike.getMotorbikeId());
        existingMotorbike.setMotorbikeName(motorbike.getMotorbikeName());
        existingMotorbike.setMotorbikeNumber(motorbike.getMotorbikeNumber());
        existingMotorbike.setMotorbikeType(motorbike.getMotorbikeType());
        return motorbikeRepo.save(existingMotorbike);
    }

    public Motorbike addMotorbike(MotorbikeDTO motorbikeDTO) {
        Motorbike motorbike = Motorbike.builder()
                .motorbikeName(motorbikeDTO.getMotorbikeName())
                .motorbikeNumber(motorbikeDTO.getMotorbikeNumber())
                .motorbikeType(motorbikeDTO.getMotorbikeType())
                .customer(customerRepo.findByCustomerId(motorbikeDTO.getCustomerId()))
                .build();
        return motorbikeRepo.save(motorbike);
    }

}