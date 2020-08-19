package com.flexicore.order.model;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;

@Entity
public class SupplyTime extends Baseclass {
    static SupplyTime s_Singleton = new SupplyTime();
    public static SupplyTime s() {
        return s_Singleton;
    }


    private int dayOfTheWeek;
    private int hour;
    private int minute;
    private int second;

    public SupplyTime() {
    }

    public SupplyTime(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    public int getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public <T extends SupplyTime> T setDayOfTheWeek(int dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
        return (T) this;
    }

    public int getHour() {
        return hour;
    }

    public <T extends SupplyTime> T setHour(int hour) {
        this.hour = hour;
        return (T) this;
    }

    public int getMinute() {
        return minute;
    }

    public <T extends SupplyTime> T setMinute(int minute) {
        this.minute = minute;
        return (T) this;
    }

    public int getSecond() {
        return second;
    }

    public <T extends SupplyTime> T setSecond(int second) {
        this.second = second;
        return (T) this;
    }
}
