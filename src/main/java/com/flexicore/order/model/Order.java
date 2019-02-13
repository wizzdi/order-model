package com.flexicore.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.organization.model.Organization;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Order extends Organization {
    static Order s_Singleton = new Order();
    public static Order s() {
        return s_Singleton;
    }

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
}