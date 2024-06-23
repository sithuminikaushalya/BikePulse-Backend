package com.motorbike_reservation_system.backend.Authentication.Shop.Service.Impl;

import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopDetailsImageDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopLoginDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopPasswordDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.Shop;
import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ProfileImageDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.ShopDetailsImages;
import com.motorbike_reservation_system.backend.Authentication.Shop.Repo.ShopDetailsImageRepo;
import com.motorbike_reservation_system.backend.Authentication.Shop.Response.ShopLoginResponse;
import com.motorbike_reservation_system.backend.Authentication.Shop.Repo.ShopRepo;
import com.motorbike_reservation_system.backend.Authentication.Shop.Service.ShopEmailService;
import com.motorbike_reservation_system.backend.Authentication.Shop.Service.ShopService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class ShopImpl implements ShopService {
    @Autowired
    private ShopRepo shopRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ShopEmailService shopEmailService;




    public int addShop(ShopDTO shopDTO) {
        Shop shop = Shop.builder()
                .shopId(shopDTO.getShopId())
                .shopName(shopDTO.getShopName())
                .shopPassword(this.passwordEncoder.encode(shopDTO.getShopPassword()))
                .shopAddress(shopDTO.getShopAddress())
                .contactNumber(shopDTO.getContactNumber())
                .taxId(shopDTO.getTaxId())
                .email(shopDTO.getEmail())
                .subscriptionPlan(shopDTO.getSubscriptionPlan())
                .activeStatus(Optional.ofNullable(shopDTO.getActiveStatus()).orElse("active"))
                .approvedStatus(Optional.ofNullable(shopDTO.getApprovedStatus()).orElse("pending"))
                .build();
        shopRepo.save(shop);

        // Send confirmation email
        shopEmailService.sendShopRegistrationConfirmation(shop.getEmail(), shop.getShopName());

        return shop.getShopId();
    }



    public Shop savePassword(ShopPasswordDTO shopPasswordDTO) {
        Shop existingShop = shopRepo.findByShopId(shopPasswordDTO.getShopId());
        existingShop.setShopPassword(this.passwordEncoder.encode(shopPasswordDTO.getShopPassword()));
        return shopRepo.save(existingShop);
    }


    public List<Shop> getShop() {
        return shopRepo.findAll();
    }
    public List<Object[]> getShopDetails() {
        return shopRepo.findShopDetails();
    }


    @Override
    public ShopLoginResponse loginShop(ShopLoginDTO shopLoginDTO) {
        String msg="";
        Shop shop1 = shopRepo.findByEmail(shopLoginDTO.getEmail());
        if(shop1!= null){
            String password = shopLoginDTO.getShopPassword();
            String encodePassword = shop1.getShopPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodePassword);
            if (isPasswordRight){
                Optional<Shop> shop = shopRepo.findOneByEmailAndShopPassword(shopLoginDTO.getEmail(), encodePassword);
                if (shop.isPresent()){
                    return new ShopLoginResponse(shop1.getShopId(), "Login Successfully",true );
                }
                else return new ShopLoginResponse(0, "Login Failed",false);
            }
            else return new ShopLoginResponse(0,"Password not Match", false);
        }
        else return new ShopLoginResponse(0,"Email not Exists",false);
    }



    public List<Shop> searchUsers(String shopName, String shopAddress, String email) {
        return shopRepo.findByNameAddressEmail(shopName, shopAddress, email);
    }

    public List<Shop> searchUsers(String searchTerm) {
        return shopRepo.findByShopNameOrShopAddressOrEmail(searchTerm);
    }

    @Transactional
    public void updateActiveStatus(int shopId, String activeStatus) {
        shopRepo.updateActiveStatus(shopId, activeStatus);

        if ("deactivated".equalsIgnoreCase(activeStatus)) {
            Shop shop = shopRepo.findByShopId(shopId);//.orElse(null);
            if (shop != null) {
                shopEmailService.sendShopDeactivationNotification(shop.getEmail(), shop.getShopName());
            }
        }
    }


    @Transactional
    public void updateApprovedStatus(int shopId, String approvedStatus) {
        shopRepo.updateApprovedStatus(shopId, approvedStatus);

        Shop shop = shopRepo.findByShopId(shopId);//.orElse(null);
        if (shop != null) {
            if ("approved".equalsIgnoreCase(approvedStatus)) {
                shopEmailService.sendShopApprovedNotification(shop.getEmail(), shop.getShopName());
            } else if ("rejected".equalsIgnoreCase(approvedStatus)) {
                shopEmailService.sendShopRejectedNotification(shop.getEmail(), shop.getShopName());
            } else if ("pending".equalsIgnoreCase(approvedStatus)) {
                shopEmailService.sendShopPendingNotification(shop.getEmail(), shop.getShopName());
            }
        }
    }


    public Shop getShopById(int shopId) {
        return shopRepo.findByShopId(shopId);//.orElseThrow(() -> new RuntimeException("User not found"));
    }


    // shop profile picture
    public ProfileImageDTO getProfileImageById(int shopId) {
        Shop shop = shopRepo.findByShopId(shopId);
                //.orElseThrow(() -> new RuntimeException("Shop not found"));
        return ProfileImageDTO.builder()
                .shopId(shop.getShopId())
                .profileImage(shop.getProfileImage())
                .build();
    }

    public void deleteProfileImage(int shopId) {
        Shop shop = shopRepo.findByShopId(shopId);
                //.orElseThrow(() -> new RuntimeException("Shop not found"));
        shop.setProfileImage(null);
        shopRepo.save(shop);
    }

    public ProfileImageDTO updateProfileImage(ProfileImageDTO profileImageDTO) {
        Shop existingShop = shopRepo.findByShopId(profileImageDTO.getShopId());
                //.orElseThrow(() -> new RuntimeException("Shop not found"));
        existingShop.setProfileImage(profileImageDTO.getProfileImage());
        shopRepo.save(existingShop);
        return profileImageDTO;
    }


}
