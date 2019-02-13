package com.flexicore.order.model;

import com.flexicore.model.Baseclass;
import com.flexicore.organization.model.Organization;
import com.flexicore.product.model.Product;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class OrderItem extends Baseclass {
    static OrderItem s_Singleton = new OrderItem();
    public static OrderItem s() {
        return s_Singleton;
    }


    private int quantity;
    @ManyToOne(targetEntity = Product.class)
    private Product product;
    @ManyToOne(targetEntity = Order.class)
    private Order order;

    public int getQuantity() {
        return quantity;
    }

    public <T extends OrderItem> T setQuantity(int quantity) {
        this.quantity = quantity;
        return (T) this;
    }

    @ManyToOne(targetEntity = Product.class)
    public Product getProduct() {
        return product;
    }

    public <T extends OrderItem> T setProduct(Product product) {
        this.product = product;
        return (T) this;
    }

    @ManyToOne(targetEntity = Order.class)
    public Order getOrder() {
        return order;
    }

    public <T extends OrderItem> T setOrder(Order order) {
        this.order = order;
        return (T) this;
    }
}
