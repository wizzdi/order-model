package com.flexicore.order.model;

import com.flexicore.model.Baselink;
import com.flexicore.organization.model.Supplier;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderApiConfigToSupplier extends Baselink {
    static OrderApiConfigToSupplier s_Singleton = new OrderApiConfigToSupplier();
    public static OrderApiConfigToSupplier s() {
        return s_Singleton;
    }

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public <T extends OrderApiConfigToSupplier> T setEnabled(boolean enabled) {
        this.enabled = enabled;
        return (T) this;
    }

    @Override
    @ManyToOne(targetEntity = OrderApiConfig.class, cascade = {CascadeType.MERGE , CascadeType.PERSIST})
    public OrderApiConfig getLeftside() {
        return (OrderApiConfig) super.getLeftside();
    }

    public void setLeftside(OrderApiConfig leftside) {
        super.setLeftside(leftside);
    }


    @Override
    @ManyToOne(targetEntity = Supplier.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public Supplier getRightside() {
        return (Supplier) super.getRightside();
    }

    public void setRightside(Supplier rightside) {
        super.setRightside(rightside);
    }

}
