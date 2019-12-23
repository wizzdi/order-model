package com.flexicore.order.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.organization.model.Supplier;
import com.flexicore.security.SecurityContext;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderApiConfig extends Baseclass {

    public OrderApiConfig() {
    }

    public OrderApiConfig(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @JsonIgnore
    @ManyToOne(targetEntity = Supplier.class)
    private String supplierId;
    @ManyToOne(targetEntity = Supplier.class)
    private Supplier supplier;
    private String host;
    private String username;
    private String password;

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

    @ManyToOne(targetEntity = Supplier.class)
    public Supplier getSupplier() {
        return supplier;
    }

    public <T extends OrderApiConfig> T setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return (T) this;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public <T extends OrderApiConfig> T setSupplierId(String supplierId) {
        this.supplierId = supplierId;
        return (T) this;
    }
}
