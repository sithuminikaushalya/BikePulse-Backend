//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import com.motorbike_reservation_system.backend.Fault_Management.Fault;
//import com.motorbike_reservation_system.backend.Fault_Management.FaultController;
//import com.motorbike_reservation_system.backend.Fault_Management.FaultService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class FaultControllerTest {
//
//    @Mock
//    private FaultService faultService;
//
//    @InjectMocks
//    private FaultController faultController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testAddFault() {
//        Fault mockFaultDTO = new Fault();
//        mockFaultDTO.setFaultName("Test Fault");
//
//        Fault mockFault = new Fault();
//        mockFault.setFaultId("1");
//        mockFault.setFaultName("Test Fault");
//
//        when(faultService.addFault(any(Fault.class))).thenReturn(mockFault);
//
//        Fault addedFault = faultController.addFault(mockFault);
//
//        assertEquals(mockFault.getFaultName(), addedFault.getFaultName());
//        assertEquals(mockFault.getFaultId(), addedFault.getFaultId());
//    }
//
//    @Test
//    public void testFindAllFaults() {
//        List<Fault> mockFaults = Arrays.asList(new Fault(), new Fault(), new Fault());
//        when(faultService.getFault()).thenReturn(mockFaults);
//
//        List<Fault> returnedFaults = faultController.findAllFaults();
//
//        assertEquals(mockFaults.size(), returnedFaults.size());
//    }
//
//    @Test
//    public void testFindFaultByFaultName() {
//        String faultName = "Test Fault";
//        Fault mockFault = new Fault();
//        mockFault.setFaultId("1");
//        mockFault.setFaultName(faultName);
//
//        when(faultService.getFaultByFaultName(faultName)).thenReturn(mockFault);
//
//        Fault returnedFault = faultController.findFaultByFaultName(faultName);
//
//        assertEquals(mockFault.getFaultName(), returnedFault.getFaultName());
//        assertEquals(mockFault.getFaultId(), returnedFault.getFaultId());
//    }
//
//    @Test
//    public void testUpdateFault() {
//        Fault mockFault = new Fault();
//        mockFault.setFaultId("1");
//        mockFault.setFaultName("Test Fault");
//
//        when(faultService.updateFault(any(Fault.class))).thenReturn(mockFault);
//
//        Fault updatedFault = faultController.updateFault(mockFault);
//
//        assertEquals(mockFault.getFaultName(), updatedFault.getFaultName());
//        assertEquals(mockFault.getFaultId(), updatedFault.getFaultId());
//    }
//
//    @Test
//    public void testDeleteFault() {
//        String faultId = "1";
//
//        when(faultService.deleteFault(faultId)).thenReturn("Fault deleted successfully.");
//
//        String result = faultController.deleteFault(faultId);
//
//        assertEquals("Fault deleted successfully.", result);
//    }
//}
