package com.motorbike_reservation_system.backend.SubcriptionPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface SubscriptionPlanRepo extends JpaRepository<SubscriptionPlan, String> {
    SubscriptionPlan findBySubscriptionPlanId(int subscriptionPlanId);


}
