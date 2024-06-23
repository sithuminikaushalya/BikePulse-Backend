package com.motorbike_reservation_system.backend.Authentication.Shop.Controller;

import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopDetailsImageDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.ShopDetailsImages;
import com.motorbike_reservation_system.backend.Authentication.Shop.Service.ShopDetailsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/shop/images")
public class ShopDetailsImageController {

    @Autowired
    private ShopDetailsImageService shopDetailsImageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "imageName", required = false, defaultValue = "defaultImageName") String imageName,
            @RequestParam("shopId") int shopId) {
        try {
            ShopDetailsImageDTO shopDetailsImageDTO = ShopDetailsImageDTO.builder()
                    .imageName(imageName)
                    .contentType(file.getContentType())
                    .shopDetailsImagesData(file.getBytes())
                    .shopId(shopId)
                    .build();
            int shopDetailsImagesId = shopDetailsImageService.addShopDetailsImages(shopDetailsImageDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Image uploaded successfully: " + shopDetailsImagesId);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }

    @GetMapping("/images")
    public List<ShopDetailsImages> getAllImages() {
        return shopDetailsImageService.getAllImage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImageById(@PathVariable int id) {
        ShopDetailsImages image = shopDetailsImageService.getImage(id);
        if (image != null) {
            return ResponseEntity.ok(image);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable int id) {
        try {
            shopDetailsImageService.deleteImage(id);
            return ResponseEntity.ok("Image deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete image");
        }
    }
}
