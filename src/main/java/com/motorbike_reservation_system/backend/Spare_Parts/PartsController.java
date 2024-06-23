package com.motorbike_reservation_system.backend.Spare_Parts;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/parts")
public class PartsController {

    @Autowired
    private PartsService partsService;

//    @GetMapping("/new")
//    public String add(Model model) {
//        List<Parts> listParts = partsService.getParts();
//        model.addAttribute("listParts", listParts);
//        model.addAttribute("parts", new Parts());
//        return "new";
//    }

    @PostMapping("/addParts")
    public Parts addParts(@RequestBody Parts parts) {
        return partsService.saveParts(parts);
    }

    @GetMapping("/parts")
    public List<Parts> findAllParts() {
        return partsService.getParts();
    }

    @GetMapping("/partsById/{partsId}")
    public Parts findPartsByPartsId(@PathVariable String partsId) {
        return partsService.getPartsByPartsId(partsId);
    }

    @GetMapping("/parts/{partsName}")
    public Parts findPartsByPartsName(@PathVariable String partsName) {
        return partsService.getPartsByPartsName(partsName);
    }

//    @PutMapping("/updateParts")
//    public Parts updateParts(@RequestBody Parts parts) {
//        return partsService.updateParts(parts);
//    }

    @DeleteMapping("/deleteParts/{partsId}")
    public String deleteParts(@PathVariable String partsId) {
        return partsService.deleteParts(partsId);
    }
}
