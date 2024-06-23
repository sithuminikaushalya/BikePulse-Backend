//package com.motorbike_reservation_system.backend;
//
//import static org.mockito.Mockito.*;
//
//import java.util.Collections;
//import java.util.List;
//
//import com.motorbike_reservation_system.backend.Authentication.Shop.Controller.ShopController;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopDTO;
//import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopLoginDTO;
//import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopPasswordDTO;
//import com.motorbike_reservation_system.backend.Authentication.Shop.Entity.Shop;
//import com.motorbike_reservation_system.backend.Authentication.Shop.Response.ShopLoginResponse;
//import com.motorbike_reservation_system.backend.Authentication.Shop.Service.Impl.ShopImpl;
//import com.motorbike_reservation_system.backend.Authentication.Shop.Service.ShopService;
//
//@ExtendWith(MockitoExtension.class)
//public class ShopControllerTest {
//
//    @Mock
//    private ShopService shopService;
//
//    @Mock
//    private ShopImpl shopImpl;
//
//    @InjectMocks
//    private ShopController shopController;
//
//    @Test
//    public void testAddShop() {
//        // Given
//        ShopDTO shopDTO = new ShopDTO();
//        shopDTO.getShopName("My Shop");
//
//        int shopId = 1;
//
//        when(shopImpl.addShop(shopDTO)).thenReturn(shopId);
//
//        // When
//        int result = shopController.addShop(shopDTO);
//
//        // Then
//        assert shopId == result;
//    }
//
////    @Test
////    public void testUpdatePassword() {
////        // Given
////        ShopPasswordDTO shopPasswordDTO = new ShopPasswordDTO();
////        shopPasswordDTO.(1);
////        shopPasswordDTO.setNewPassword("newPassword");
////
////        Shop updatedShop = new Shop(); // Assuming your service returns the updated shop entity
////
////        when(shopImpl.savePassword(shopPasswordDTO)).thenReturn(updatedShop);
////
////        // When
////        Shop result = shopController.updatePassword(shopPasswordDTO);
////
////        // Then
////        assert result == updatedShop;
////    }
//
//    @Test
//    public void testLoginShop() {
//        // Given
//        ShopLoginDTO shopLoginDTO = new ShopLoginDTO();
//        shopLoginDTO.setEmail("username");
//        shopLoginDTO.setShopPassword("password");
//
//        ShopLoginResponse loginResponse = new ShopLoginResponse();
//        //loginResponse.setStatus(0);
//        loginResponse.setMessage("Login successful");
//
//        when(shopService.loginShop(shopLoginDTO)).thenReturn(loginResponse);
//
//        // When
//        ResponseEntity<?> responseEntity = shopController.loginShop(shopLoginDTO);
//
//        // Then
//        assert responseEntity.getStatusCode() == HttpStatus.OK;
//        assert responseEntity.getBody() == loginResponse;
//    }
//
//    @Test
//    public void testFindAllShop() {
//        // Given
//        List<Shop> shops = Collections.singletonList(new Shop());
//
//        when(shopImpl.getShop()).thenReturn(shops);
//
//        // When
//        List<Shop> result = shopController.findAllShop();
//
//        // Then
//        assert result == shops;
//    }
//
//    // You can write similar tests for findShopDetails() if needed
//}
