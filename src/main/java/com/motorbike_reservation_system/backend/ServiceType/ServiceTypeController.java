package com.motorbike_reservation_system.backend.ServiceType;

import com.motorbike_reservation_system.backend.ServiceType.Entity.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/serviceType")
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    @PostMapping("/addServiceType")
    public ServiceType addServiceType(ServiceType serviceType) {
        return serviceTypeService.saveServiceType(serviceType);
    }

    @GetMapping("/serviceType")
    public List<ServiceType> findAllServiceType() {
        return serviceTypeService.getAllServiceType();
    }

    @GetMapping("/serviceTypeById/{serviceTypeId}")
    public ServiceType findServiceTypeByServiceTypeId(@PathVariable String serviceTypeId) {
        return serviceTypeService.getServiceType(serviceTypeId);
    }

    @PutMapping("/updateServiceType")
    public ServiceType updateServiceType(ServiceType serviceType) {
        return serviceTypeService.updateServiceType(serviceType);
    }

    @DeleteMapping("/deleteServiceType/{serviceTypeId}")
    public String deleteServiceType(@PathVariable String serviceTypeId) {
        return serviceTypeService.deleteServiceType(serviceTypeId);
    }


}
