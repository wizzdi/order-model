package com.flexicore.order.model;

import com.flexicore.model.Baseclass;

import javax.persistence.Entity;


@Entity
public class OrderApiConfig extends Baseclass {
    static OrderApiConfig s_Singleton = new OrderApiConfig();
    public static OrderApiConfig s() {
        return s_Singleton;
    }

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
}
