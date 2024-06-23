package com.motorbike_reservation_system.backend.SubcriptionPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepo subscriptionPlanRepo;

    public SubscriptionPlan saveSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        return subscriptionPlanRepo.save(subscriptionPlan);
    }

    public List<SubscriptionPlan> getSubscriptionPlan() {
        return subscriptionPlanRepo.findAll();
    }

    public SubscriptionPlan getSubscriptionPlan(int subscriptionPlan) {
        return subscriptionPlanRepo.findBySubscriptionPlanId(subscriptionPlan);
    }

    public String deleteSubscriptionPlan(String subscriptionPlanId) {
        subscriptionPlanRepo.deleteById(subscriptionPlanId);
        return "product removed !! " + subscriptionPlanId;
    }

    public SubscriptionPlan updateSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        SubscriptionPlan existingSubscriptionPlan = subscriptionPlanRepo.findBySubscriptionPlanId(subscriptionPlan.getSubscriptionPlanId());
        existingSubscriptionPlan.setSubscriptionPlanName(subscriptionPlan.getSubscriptionPlanName());
        existingSubscriptionPlan.setSubscriptionPlanDescription(subscriptionPlan.getSubscriptionPlanDescription());
        existingSubscriptionPlan.setSubscriptionPlanPrice(subscriptionPlan.getSubscriptionPlanPrice());
        return subscriptionPlanRepo.save(existingSubscriptionPlan);
    }

    public List<SubscriptionPlan> updateSubscriptionPlanArray(List<SubscriptionPlan> subscriptionPlans) {
        List<SubscriptionPlan> updatedSubscriptionPlans = new ArrayList<>();
        for (SubscriptionPlan subscriptionPlan : subscriptionPlans) {
            SubscriptionPlan existingSubscriptionPlan = subscriptionPlanRepo.findBySubscriptionPlanId(subscriptionPlan.getSubscriptionPlanId());
            if (existingSubscriptionPlan != null) {
                existingSubscriptionPlan.setSubscriptionPlanName(subscriptionPlan.getSubscriptionPlanName());
                existingSubscriptionPlan.setSubscriptionPlanDescription(subscriptionPlan.getSubscriptionPlanDescription());
                existingSubscriptionPlan.setSubscriptionPlanPrice(subscriptionPlan.getSubscriptionPlanPrice());
                updatedSubscriptionPlans.add(subscriptionPlanRepo.save(existingSubscriptionPlan));
            }
        }
        return updatedSubscriptionPlans;
    }

}
