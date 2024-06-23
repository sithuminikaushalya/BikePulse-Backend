import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import com.motorbike_reservation_system.backend.Authentication.Admin.Controller.AdminController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.motorbike_reservation_system.backend.Authentication.Admin.Dto.AdminDTO;
import com.motorbike_reservation_system.backend.Authentication.Admin.Dto.AdminLoginDTO;
import com.motorbike_reservation_system.backend.Authentication.Admin.Entity.Admin;
import com.motorbike_reservation_system.backend.Authentication.Admin.Response.AdminLoginResponse;
import com.motorbike_reservation_system.backend.Authentication.Admin.Service.AdminService;
import com.motorbike_reservation_system.backend.Authentication.Admin.Service.Impl.AdminIMPL;

@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @Mock
    private AdminIMPL adminIMPL;

    @InjectMocks
    private AdminController adminController;

    @Test
    public void testSaveAdmin() {
        // Given
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setAdminName("John");
        adminDTO.setAdminEmail("john@example.com");

        String adminId = "1";

        when(adminService.addAdmin(adminDTO)).thenReturn(adminId);

        // When
        String result = adminController.saveAdmin(adminDTO);

        // Then
        assert adminId.equals(result);
    }

    @Test
    public void testLoginAdmin() {
        // Given
        AdminLoginDTO adminLoginDTO = new AdminLoginDTO();
        adminLoginDTO.setAdminEmail("john");
        adminLoginDTO.setAdminPassword("password");

        AdminLoginResponse loginResponse = new AdminLoginResponse();
        //loginResponse.setStatus("true");
        loginResponse.setMessage("Login successful");

        when(adminService.loginAdmin(adminLoginDTO)).thenReturn(loginResponse);

        // When
        ResponseEntity<?> responseEntity = adminController.loginAdmin(adminLoginDTO);

        // Then
        assert responseEntity.getStatusCode() == HttpStatus.OK;
        assert responseEntity.getBody() == loginResponse;
    }

    @Test
    public void testFindAllAdmin() {
        // Given
        List<Admin> admins = Collections.singletonList(new Admin());

        when(adminIMPL.getAdmin()).thenReturn(admins);

        // When
        List<Admin> result = adminController.findAllAdmin();

        // Then
        assert result == admins;
    }
}
