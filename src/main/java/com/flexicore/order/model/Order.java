package com.flexicore.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Order extends Baseclass {
    static Order s_Singleton = new Order();
    public static Order s() {
        return s_Singleton;
    }
    private String externalId;

    @OneToMany(targetEntity = OrderItem.class,mappedBy = "order")
    @JsonIgnore
    private List<OrderItem> orderItems=new ArrayList<>();

    @OneToMany(targetEntity = OrderItem.class,mappedBy = "order")
    @JsonIgnore
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public <T extends Order> T setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        return (T) this;
    }

    public String getExternalId() {
        return externalId;
    }

    public <T extends Order> T setExternalId(String externalId) {
        this.externalId = externalId;
        return (T) this;
    }
}
