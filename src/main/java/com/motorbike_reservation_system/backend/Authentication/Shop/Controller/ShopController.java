package com.motorbike_reservation_system.backend.Authentication.Shop.Controller;

import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.*;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.Shop;
import com.motorbike_reservation_system.backend.Authentication.Shop.Response.ShopLoginResponse;
import com.motorbike_reservation_system.backend.Authentication.Shop.Service.Impl.ShopImpl;
import com.motorbike_reservation_system.backend.Authentication.Shop.Service.Impl.ShopInformationService;
import com.motorbike_reservation_system.backend.Authentication.Shop.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopInformationService shopInformationService;
    @Autowired
    private ShopImpl shopImpl;


    @PostMapping(path= "/save")
    public ResponseEntity<?> addShop(@RequestBody ShopDTO shopDTO){
        int shopId = shopImpl.addShop(shopDTO);

        // Create a ShopLoginDTO object containing the newly created shop ID
        ShopLoginDTO shopLoginDTO = new ShopLoginDTO();
        shopLoginDTO.setEmail(shopDTO.getEmail());
        shopLoginDTO.setShopPassword(shopDTO.getShopPassword());

        // Call the loginShop method to generate the login response
        ShopLoginResponse shopLoginResponse = shopService.loginShop(shopLoginDTO);

        // Return the shop ID and login response in a ResponseEntity
        return ResponseEntity.ok(shopLoginResponse);
    }

    @PostMapping(path = "/updatePassword")
    public Shop updatePassword(@RequestBody ShopPasswordDTO shopPasswordDTO){
        return shopImpl.savePassword(shopPasswordDTO);

    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginShop(@RequestBody ShopLoginDTO shopLoginDTO){
        ShopLoginResponse shopLoginResponse = shopService.loginShop(shopLoginDTO);
        return ResponseEntity.ok(shopLoginResponse);
    }

    @GetMapping("/getShop")
    public List<Shop> findAllShop() {
        return shopImpl.getShop();
    }

    @GetMapping("/getShopDetails")
    public List<Object[]> findShopDetails() {
        return shopImpl.getShopDetails();
    }

    @GetMapping("/searchShop")
    public List<Shop> searchUsers(
            @RequestParam("shopName") String shopName,
            @RequestParam("shopAddress") String shopAddress,
            @RequestParam("email") String email
    ) {
        return shopImpl.searchUsers(shopName, shopAddress, email);
    }

    @GetMapping("/search")
    public List<Shop> searchUsers(@RequestParam("q") String searchTerm) {
        return shopImpl.searchUsers(searchTerm);
    }

    @PutMapping("/{shopId}/active-status")
    public void updateActiveStatus(@PathVariable int shopId, @RequestParam String activeStatus) {
        shopImpl.updateActiveStatus(shopId, activeStatus);
    }

    @PutMapping("/{shopId}/approved-status")
    public void updateApprovedStatus(@PathVariable int shopId, @RequestParam String approvedStatus) {
        shopImpl.updateApprovedStatus(shopId, approvedStatus);
    }

    @GetMapping("/{shopId}")
    public Shop getShopById(@PathVariable int shopId) {
        return shopImpl.getShopById(shopId);
    }

    // Shop Profile
    @GetMapping("/{shopId}/profile-image")
    public ResponseEntity<ProfileImageDTO> getProfileImage(@PathVariable int shopId) {
        ProfileImageDTO profileImageDTO = shopImpl.getProfileImageById(shopId);
        return ResponseEntity.ok(profileImageDTO);
    }

    @DeleteMapping("/{shopId}/profile-image")
    public ResponseEntity<Void> deleteProfileImage(@PathVariable int shopId) {
        shopImpl.deleteProfileImage(shopId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{shopId}/profile-image")
    public ResponseEntity<ProfileImageDTO> updateProfileImage(
            @PathVariable int shopId,
            @RequestBody ProfileImageDTO profileImageDTO) {
        profileImageDTO.setShopId(shopId);
        ProfileImageDTO updatedProfileImage = shopImpl.updateProfileImage(profileImageDTO);
        return ResponseEntity.ok(updatedProfileImage);
    }


    //shop information
    @GetMapping("/{shopId}/information")
    public ResponseEntity<ShopInformationDTO> getShopInformation(@PathVariable int shopId) {
        ShopInformationDTO shopInformationDTO = shopInformationService.getShopInformationById(shopId);
        return ResponseEntity.ok(shopInformationDTO);
    }

    @DeleteMapping("/{shopId}/information")
    public ResponseEntity<Void> deleteShopInformation(@PathVariable int shopId) {
        shopInformationService.deleteShopInformation(shopId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{shopId}/information")
    public ResponseEntity<ShopInformationDTO> updateShopInformation(
            @PathVariable int shopId,
            @RequestBody ShopInformationDTO shopInformationDTO) {
        shopInformationDTO.setShopId(shopId);
        ShopInformationDTO updatedShopInformation = shopInformationService.updateShopInformation(shopInformationDTO);
        return ResponseEntity.ok(updatedShopInformation);
    }

}
