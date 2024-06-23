package com.motorbike_reservation_system.backend.Repair_Service;

import com.motorbike_reservation_system.backend.Motorbike.Motorbike;
import com.motorbike_reservation_system.backend.Motorbike.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/service")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @PostMapping("/addService")
    public Repair addService(@RequestBody RepairDTO repairDTO) {
        return repairService.addService(repairDTO);
    }

    @GetMapping("/services")
    public List<Repair> findAllServices() {
        return repairService.getService();
    }

    @GetMapping("/ServiceById/{repairServiceId}")
    public Repair findServiceByRepairServiceId(@PathVariable String repairServiceId) {
        return repairService.getServiceByRepairServiceId(repairServiceId);
    }

    @PutMapping("/updateService")
    public Repair updateService(@RequestBody Repair repair) {
        return repairService.updateService(repair);
    }

    @DeleteMapping("/deleteService/{repairServiceId}")
    public String deleteService(@PathVariable String repairServiceId) {
        return repairService.deleteService(repairServiceId);
    }

}

