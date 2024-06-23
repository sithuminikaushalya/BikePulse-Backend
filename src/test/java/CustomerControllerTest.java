import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import com.motorbike_reservation_system.backend.Authentication.Customer.Controller.CustomerController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.motorbike_reservation_system.backend.Authentication.Customer.Dto.CustomerDTO;
import com.motorbike_reservation_system.backend.Authentication.Customer.Dto.CustomerLoginDTO;
import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.Customer;
import com.motorbike_reservation_system.backend.Authentication.Customer.Response.CustomerLoginResponse;
import com.motorbike_reservation_system.backend.Authentication.Customer.Service.CustomerService;
import com.motorbike_reservation_system.backend.Authentication.Customer.Service.Impl.CustomerImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private CustomerImpl customerImpl;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void testAddCustomer() {
        // Given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName("John");
        customerDTO.setCustomerEmail("john@example.com");

        int customerId = 1;

        when(customerService.addCustomer(customerDTO)).thenReturn(customerId);

        // When
        int result = customerController.addCustomer(customerDTO);

        // Then
        assert customerId == result;
    }

    @Test
    public void testLoginCustomer() {
        // Given
        CustomerLoginDTO customerLoginDTO = new CustomerLoginDTO();
        customerLoginDTO.setCustomerEmail("john");
        customerLoginDTO.setCustomerPassword("password");

        CustomerLoginResponse loginResponse = new CustomerLoginResponse();
        loginResponse.setCustomerId(1);
        loginResponse.setMessage("Login successful");

        when(customerService.loginCustomer(customerLoginDTO)).thenReturn(loginResponse);

        // When
        ResponseEntity<?> responseEntity = customerController.loginCustomer(customerLoginDTO);

        // Then
        assert responseEntity.getStatusCode() == HttpStatus.OK;
        assert responseEntity.getBody() == loginResponse;
    }

    @Test
    public void testFindAllCustomer() {
        // Given
        List<Customer> customers = Collections.singletonList(new Customer());

        when(customerImpl.getCustomer()).thenReturn(customers);

        // When
        List<Customer> result = customerController.findAllCustomer();

        // Then
        assert result == customers;
    }
}
