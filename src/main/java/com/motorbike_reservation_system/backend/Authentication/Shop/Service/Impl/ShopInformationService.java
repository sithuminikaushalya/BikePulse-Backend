package com.motorbike_reservation_system.backend.Authentication.Shop.Service.Impl;

import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopInformationDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.Shop;
import com.motorbike_reservation_system.backend.Authentication.Shop.Repo.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopInformationService {

    @Autowired
    private ShopRepo shopRepository;

    public ShopInformationDTO getShopInformationById(int shopId) {
        Shop shop = shopRepository.findByShopId(shopId);
               return convertToDTO(shop);
    }

    public void deleteShopInformation(int shopId) {
        if (!shopRepository.existsByShopId(shopId)) {
            throw new RuntimeException("Shop not found");
        }
        shopRepository.deleteById(shopId);
    }

    public ShopInformationDTO updateShopInformation(ShopInformationDTO shopInformationDTO) {
        Shop existingShop = shopRepository.findByShopId(shopInformationDTO.getShopId());

        updateShopEntity(existingShop, shopInformationDTO);
        shopRepository.save(existingShop);
        return shopInformationDTO;
    }

    private ShopInformationDTO convertToDTO(Shop shop) {
        return ShopInformationDTO.builder()
                .shopId(shop.getShopId())
                .openingTime(shop.getOpeningTime())
                .closingTime(shop.getClosingTime())
                .shopDescription(shop.getShopDescription())
                .shopMission(shop.getShopMission())
                .latitude(shop.getLatitude())
                .longitude(shop.getLongitude())
                .build();
    }

    private void updateShopEntity(Shop shop, ShopInformationDTO shopInformationDTO) {
        shop.setOpeningTime(shopInformationDTO.getOpeningTime());
        shop.setClosingTime(shopInformationDTO.getClosingTime());
        shop.setShopDescription(shopInformationDTO.getShopDescription());
        shop.setShopMission(shopInformationDTO.getShopMission());
        shop.setLatitude(shopInformationDTO.getLatitude());
        shop.setLongitude(shopInformationDTO.getLongitude());
    }
}
