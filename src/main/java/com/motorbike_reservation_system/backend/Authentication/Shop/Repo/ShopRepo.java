package com.motorbike_reservation_system.backend.Authentication.Shop.Repo;

import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.Shop;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface ShopRepo extends JpaRepository<Shop,Integer> {

    Optional<Shop> findOneByEmailAndShopPassword(String Email, String ShopPassword);
    Shop findByEmail(String Email);

    Shop findByShopId(int shopId);
    boolean existsByShopId(int shopId);

    @Query("SELECT s.shopId AS shopId, s.shopName AS shopName, s.shopPassword AS shopPassword, s.shopAddress AS shopAddress, s.contactNumber AS contactNumber FROM Shop s")
    List<Object[]> findShopDetails();

    @Query("SELECT u FROM Shop u WHERE " +
            "LOWER(u.shopName) LIKE LOWER(CONCAT('%', :shopName, '%')) AND " +
            "LOWER(u.shopAddress) LIKE LOWER(CONCAT('%', :shopAddress, '%')) AND " +
            "LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%'))")
    List<Shop> findByNameAddressEmail(
            @Param("shopName") String shopName,
            @Param("shopAddress") String shopAddress,
            @Param("email") String email
    );

    @Query("SELECT u FROM Shop u WHERE " +
            "LOWER(u.shopName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.shopAddress) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.email) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Shop> findByShopNameOrShopAddressOrEmail(@Param("searchTerm") String searchTerm);

    @Modifying
    @Transactional
    @Query("UPDATE Shop u SET u.activeStatus = :activeStatus WHERE u.shopId = :shopId")
    void updateActiveStatus(@Param("shopId") int shopId, @Param("activeStatus") String activeStatus);

    @Modifying
    @Transactional
    @Query("UPDATE Shop u SET u.approvedStatus = :approvedStatus WHERE u.shopId = :shopId")
    void updateApprovedStatus(@Param("shopId") int shopId, @Param("approvedStatus") String approvedStatus);


}