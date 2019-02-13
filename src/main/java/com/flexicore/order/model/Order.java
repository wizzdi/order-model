package com.flexicore.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.organization.model.Organization;
import com.flexicore.organization.model.Supplier;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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

    @ManyToOne(targetEntity = Organization.class)
    private Organization consumingOrganization;

    @ManyToOne(targetEntity = Supplier.class)
    private Supplier supplier;

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

    @ManyToOne(targetEntity = Organization.class)
    public Organization getConsumingOrganization() {
        return consumingOrganization;
    }

    public <T extends Order> T setConsumingOrganization(Organization organization) {
        this.consumingOrganization = organization;
        return (T) this;
    }

    @ManyToOne(targetEntity = Supplier.class)
    public Supplier getSupplier() {
        return supplier;
    }

    public <T extends Order> T setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return (T) this;
    }
}
