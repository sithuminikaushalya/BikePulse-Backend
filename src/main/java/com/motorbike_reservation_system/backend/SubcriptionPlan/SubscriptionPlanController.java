package com.motorbike_reservation_system.backend.SubcriptionPlan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/subscriptionPlan")
public class SubscriptionPlanController{

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @PostMapping("/addSubscriptionPlan")
    public SubscriptionPlan addSubscriptionPlan(@RequestBody SubscriptionPlan subscriptionPlan) {
        return subscriptionPlanService.saveSubscriptionPlan(subscriptionPlan);
    }

    @GetMapping("/subscriptionPlan")
    public List<SubscriptionPlan> findAllSubscriptionPlan() {
        return subscriptionPlanService.getSubscriptionPlan();
    }

    @GetMapping("/subscriptionPlanById/{subscriptionPlanId}")
    public SubscriptionPlan findSubscriptionPlanBySubscriptionPlanId(@PathVariable int subscriptionPlanId) {
        return subscriptionPlanService.getSubscriptionPlan(subscriptionPlanId);
    }

    @PutMapping("/updateSubscriptionPlan")
    public SubscriptionPlan updateSubscriptionPlan(@RequestBody SubscriptionPlan subscriptionPlan) {
        return subscriptionPlanService.updateSubscriptionPlan(subscriptionPlan);
    }
    @PutMapping("/updateMultipleSubscriptionPlans")
    public List<SubscriptionPlan> updateSubscriptionPlanArray(@RequestBody List<SubscriptionPlan> subscriptionPlans) {
        return subscriptionPlanService.updateSubscriptionPlanArray(subscriptionPlans);
    }

    @DeleteMapping("/deleteSubscriptionPlan/{subscriptionPlanId}")
    public String deleteSubscriptionPlan(@PathVariable String subscriptionPlanId) {
        return subscriptionPlanService.deleteSubscriptionPlan(subscriptionPlanId);
    }

}
