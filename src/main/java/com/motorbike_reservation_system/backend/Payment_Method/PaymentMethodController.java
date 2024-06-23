package com.motorbike_reservation_system.backend.Payment_Method;

import com.motorbike_reservation_system.backend.Motorbike.Motorbike;
import com.motorbike_reservation_system.backend.Motorbike.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/paymentMethod")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping("/addPaymentMethod")
    public PaymentMethod addPaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO) {
        return paymentMethodService.addPaymentMethod(paymentMethodDTO);
    }

    @GetMapping("/paymentMethods")
    public List<PaymentMethod> findAllPaymentMethods() {
        return paymentMethodService.getPaymentMethod();
    }

    @GetMapping("/PaymentMethodById/{paymentMethodId}")
    public PaymentMethod findPaymentMethodByPaymentMethodId(@PathVariable String paymentMethodId) {
        return paymentMethodService.getPaymentMethodByPaymentMethodId(paymentMethodId);
    }

    @PutMapping("/updatePaymentMethod")
    public PaymentMethod updatePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        return paymentMethodService.updatePaymentMethod(paymentMethod);
    }

    @DeleteMapping("/deletePaymentMethod/{paymentMethodId}")
    public String deletePaymentMethod(@PathVariable String paymentMethodId) {
        return paymentMethodService.deletePaymentMethod(paymentMethodId);
    }

}

