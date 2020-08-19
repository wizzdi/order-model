package com.flexicore.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.organization.model.Organization;
import com.flexicore.organization.model.Supplier;
import com.flexicore.security.SecurityContext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Order extends Baseclass {
    private String externalId;

    private int ordinal;

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime orderSentDate;

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime orderDate;

    @ManyToOne(targetEntity = Organization.class)
    private Organization consumingOrganization;

    @ManyToOne(targetEntity = Supplier.class)
    private Supplier supplier;

    @OneToMany(targetEntity = OrderItem.class,mappedBy = "order")
    @JsonIgnore
    private List<OrderItem> orderItems=new ArrayList<>();

    public Order() {
    }

    public Order(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

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

    public OffsetDateTime getOrderDate() {
        return orderDate;
    }

    public <T extends Order> T setOrderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
        return (T) this;
    }

    public OffsetDateTime getOrderSentDate() {
        return orderSentDate;
    }

    public <T extends Order> T setOrderSentDate(OffsetDateTime orderSentDate) {
        this.orderSentDate = orderSentDate;
        return (T) this;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public <T extends Order> T setOrdinal(int ordinal) {
        this.ordinal = ordinal;
        return (T) this;
    }
}
