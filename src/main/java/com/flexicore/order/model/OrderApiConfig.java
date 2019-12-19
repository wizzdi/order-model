package com.flexicore.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class OrderApiConfig extends Baseclass {
    static OrderApiConfig s_Singleton = new OrderApiConfig();
    public static OrderApiConfig s() {
        return s_Singleton;
    }

    private String host;
    private String username;
    private String password;

    @JsonIgnore
    @OneToMany(targetEntity = OrderApiConfigToSupplier.class,mappedBy = "leftside")
    private List<OrderApiConfigToSupplier> suppliers=new ArrayList<>();

    public String getHost() {
        return host;
    }

    public <T extends OrderApiConfig> T setHost(String host) {
        this.host = host;
        return (T) this;
    }

    public String getUsername() {
        return username;
    }

    public <T extends OrderApiConfig> T setUsername(String username) {
        this.username = username;
        return (T) this;
    }

    public String getPassword() {
        return password;
    }

    public <T extends OrderApiConfig> T setPassword(String password) {
        this.password = password;
        return (T) this;
    }

    public List<OrderApiConfigToSupplier> getSuppliers() {
        return suppliers;
    }

    public <T extends OrderApiConfig> T setSuppliers(List<OrderApiConfigToSupplier> suppliers) {
        this.suppliers = suppliers;
        return (T) this;
    }
}
