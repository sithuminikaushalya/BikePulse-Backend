package com.motorbike_reservation_system.backend.Authentication.Shop.Service;

import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopDetailsImageDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.Shop;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.ShopDetailsImages;
import com.motorbike_reservation_system.backend.Authentication.Shop.Repo.ShopDetailsImageRepo;
import com.motorbike_reservation_system.backend.Authentication.Shop.Repo.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopDetailsImageService {

    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private ShopDetailsImageRepo shopDetailsImageRepo;

    public int addShopDetailsImages(ShopDetailsImageDTO shopDetailsImageDTO) {
        Shop shop = shopRepo.findByShopId(shopDetailsImageDTO.getShopId());
        ShopDetailsImages shopDetailsImages = ShopDetailsImages.builder()
                .shopDetailsImagesId(shopDetailsImageDTO.getShopDetailsImagesId())
                .imageName(shopDetailsImageDTO.getImageName())
                .contentType(shopDetailsImageDTO.getContentType())
                .shopDetailsImagesData(shopDetailsImageDTO.getShopDetailsImagesData())
                .shop(shop)
                .build();
        shopDetailsImageRepo.save(shopDetailsImages);
        return shopDetailsImages.getShopDetailsImagesId();
    }

    public ShopDetailsImages getImage(int shopDetailsImagesId) {
        return shopDetailsImageRepo.findByShopDetailsImagesId(shopDetailsImagesId);
    }

    public List<ShopDetailsImages> getAllImage() {
        return shopDetailsImageRepo.findAll();
    }

    public void deleteImage(int shopDetailsImagesId) {
        shopDetailsImageRepo.deleteById(shopDetailsImagesId);
    }
}
