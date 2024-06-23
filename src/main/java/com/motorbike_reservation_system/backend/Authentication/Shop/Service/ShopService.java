package com.motorbike_reservation_system.backend.Authentication.Shop.Service;

import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopDetailsImageDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Dto.ShopLoginDTO;
import com.motorbike_reservation_system.backend.Authentication.Shop.Response.ShopLoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface ShopService {

    int addShop(ShopDTO shopDTO);

    ShopLoginResponse loginShop(ShopLoginDTO shopLoginDTO);


}
