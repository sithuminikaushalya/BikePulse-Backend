package com.motorbike_reservation_system.backend.ServiceType;

import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.Customer;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.Shop;
import com.motorbike_reservation_system.backend.Feedback.DTO.FeedbackDTO;
import com.motorbike_reservation_system.backend.Feedback.Feedback;
import com.motorbike_reservation_system.backend.Repair_Service.Repair;
import com.motorbike_reservation_system.backend.Reservation.Reservation;
import com.motorbike_reservation_system.backend.ServiceType.Entity.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ServiceTypeService {

    @Autowired
    private ServiceTypeRepo serviceTypeRepo;

    public ServiceType saveServiceType(ServiceType serviceType) {
        return serviceTypeRepo.save(serviceType);
    }

    public List<ServiceType> getAllServiceType() {
        return serviceTypeRepo.findAll();
    }

    public ServiceType getServiceType(String serviceType) {
        return serviceTypeRepo.findByServiceTypeId(serviceType);
    }

    public String deleteServiceType(String serviceTypeId){
        serviceTypeRepo.deleteById(serviceTypeId);
        return "Service removed !! " + serviceTypeId;
    }

    public ServiceType updateServiceType(ServiceType serviceType) {
        ServiceType existingServiceType = serviceTypeRepo.findByServiceTypeId(serviceType.getServiceTypeId());
        existingServiceType.setServiceType(serviceType.getServiceType());
        existingServiceType.setServiceTypeDescription(serviceType.getServiceTypeDescription());
        return serviceTypeRepo.save(existingServiceType);
    }



}
