package com.flexicore.order.model;

import com.flexicore.model.Baseclass;
import com.flexicore.organization.model.Organization;
import com.flexicore.product.model.Product;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem extends Baseclass {

	private int quantity;
	@ManyToOne(targetEntity = Product.class)
	private Product product;
	@ManyToOne(targetEntity = Order.class)
	private Order order;

	public OrderItem() {
	}

	public OrderItem(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

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
