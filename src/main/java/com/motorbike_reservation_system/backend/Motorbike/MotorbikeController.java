package com.motorbike_reservation_system.backend.Motorbike;

import com.motorbike_reservation_system.backend.Spare_Parts.Parts;
import com.motorbike_reservation_system.backend.Spare_Parts.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/motorbike")
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorbikeService;


    @PostMapping("/addMotorbike")
    public Motorbike addMotorbike(@RequestBody MotorbikeDTO motorbikeDTO) {
        return motorbikeService.addMotorbike(motorbikeDTO);
    }

    @GetMapping("/motorbikes")
    public List<Motorbike> findAllMotorbikes() {
        return motorbikeService.getMotorbike();
    }

    @GetMapping("/MotorbikeById/{motorbikeId}")
    public Motorbike findMotorbikeByMotorbikeId(@PathVariable String motorbikeId) {
        return motorbikeService.getMotorbikeByMotorbikeId(motorbikeId);
    }

    @GetMapping("/motorbike/{motorbikeNumber}")
    public Motorbike findMotorbikeByMotorbikenumber(@PathVariable String motorbikeNumber) {
        return motorbikeService.getMotorbikeByMotorbikeNumber(motorbikeNumber);
    }

    @PutMapping("/updateMotorbike")
    public Motorbike updateMotorbike(@RequestBody Motorbike motorbike) {
        return motorbikeService.updateMotorbike(motorbike);
    }

    @DeleteMapping("/deleteMotorbike/{motorbikeId}")
    public String deleteMotorbike(@PathVariable String motorbikeId) {
        return motorbikeService.deleteMotorbike(motorbikeId);
    }
}
