package com.motorbike_reservation_system.backend.Payment_Method;

import com.motorbike_reservation_system.backend.Motorbike.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepo extends JpaRepository<PaymentMethod,String> {
    PaymentMethod findByPaymentMethodId(String paymentMethodId);
}