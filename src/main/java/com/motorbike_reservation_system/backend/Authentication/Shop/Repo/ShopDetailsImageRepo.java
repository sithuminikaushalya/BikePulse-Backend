package com.motorbike_reservation_system.backend.Authentication.Shop.Repo;

import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.Shop;
import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.ShopDetailsImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ShopDetailsImageRepo extends JpaRepository<ShopDetailsImages, Integer> {

    ShopDetailsImages findByShopDetailsImagesId(int shopDetailsImagesId);

}
