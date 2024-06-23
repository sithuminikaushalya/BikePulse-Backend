package com.motorbike_reservation_system.backend.SubcriptionPlan;

import jakarta.persistence.*;

@Entity
@Table(name="subscription_plan")
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subscriptionPlanId;

    private String subscriptionPlanName;

    private String subscriptionPlanDescription;
    private String subscriptionPlanPrice;

    public SubscriptionPlan() {
    }

    public SubscriptionPlan(int subscriptionPlanId, String subscriptionPlanName, String subscriptionPlanDiscription, String subscriptionPlanPrice) {
        this.subscriptionPlanId = subscriptionPlanId;
        this.subscriptionPlanName = subscriptionPlanName;
        this.subscriptionPlanDescription = subscriptionPlanDiscription;
        this.subscriptionPlanPrice = subscriptionPlanPrice;
    }

    public SubscriptionPlan(String subscriptionPlanName, String subscriptionPlanDiscription, String subscriptionPlanPrice) {
        this.subscriptionPlanName = subscriptionPlanName;
        this.subscriptionPlanDescription = subscriptionPlanDiscription;
        this.subscriptionPlanPrice = subscriptionPlanPrice;
    }

    public int getSubscriptionPlanId() {
        return subscriptionPlanId;
    }

    public void setSubscriptionPlanId(int subscriptionPlanId) {
        this.subscriptionPlanId = subscriptionPlanId;
    }

    public String getSubscriptionPlanName() {
        return subscriptionPlanName;
    }

    public void setSubscriptionPlanName(String subscriptionPlanName) {
        this.subscriptionPlanName = subscriptionPlanName;
    }

    public String getSubscriptionPlanDescription() {
        return subscriptionPlanDescription;
    }

    public void setSubscriptionPlanDescription(String subscriptionPlanDescription) {
        this.subscriptionPlanDescription = subscriptionPlanDescription;
    }

    public String getSubscriptionPlanPrice() {
        return subscriptionPlanPrice;
    }

    public void setSubscriptionPlanPrice(String subscriptionPlanPrice) {
        this.subscriptionPlanPrice = subscriptionPlanPrice;
    }

    @Override
    public String toString() {
        return "SubscriptionPlan{" + "subscriptionPlanId=" + subscriptionPlanId + ", subscriptionPlanName=" + subscriptionPlanName + ", subscriptionPlanDescription=" + subscriptionPlanDescription + ", subscriptionPlanPrice=" + subscriptionPlanPrice + '}';
    }

}
