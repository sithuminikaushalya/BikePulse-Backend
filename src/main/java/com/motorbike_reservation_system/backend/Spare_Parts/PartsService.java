package com.motorbike_reservation_system.backend.Spare_Parts;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {
    @Autowired
    private PartsRepo partsRepo;



    public Parts saveParts(Parts parts) {
        return partsRepo.save(parts);
    }

    public List<Parts> saveParts(List<Parts> parts) {
        return partsRepo.saveAll(parts);
    }

    public List<Parts> getParts() {
        return partsRepo.findAll();
    }

    public Parts getPartsByPartsId(String partsId) {
        return partsRepo.findById(partsId).orElse(null);
    }

    public Parts getPartsByPartsName(String partsName) {
        return partsRepo.findByPartsName(partsName);
    }

    public String deleteParts(String partsId) {
        partsRepo.deleteById(partsId);
        return "Parts removed !! " + partsId;
    }
        public Parts addParts(Parts parts) {
            return partsRepo.save(parts);

        }

//    public Product updateProduct(Product product) {
//        Product existingProduct = repository.findById(product.getId()).orElse(null);
//        existingProduct.setName(product.getName());
//        existingProduct.setQuantity(product.getQuantity());
//        existingProduct.setPrice(product.getPrice());
//        return repository.save(existingProduct);
//    }


}
