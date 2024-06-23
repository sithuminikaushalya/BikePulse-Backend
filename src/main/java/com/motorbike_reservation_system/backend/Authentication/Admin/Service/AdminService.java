package com.motorbike_reservation_system.backend.Authentication.Admin.Service;

import com.motorbike_reservation_system.backend.Authentication.Admin.Dto.AdminDTO;
import com.motorbike_reservation_system.backend.Authentication.Admin.Dto.AdminLoginDTO;
import com.motorbike_reservation_system.backend.Authentication.Admin.Response.AdminLoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    String addAdmin(AdminDTO adminDTO);

    AdminLoginResponse loginAdmin(AdminLoginDTO adminLoginDTO);
}
