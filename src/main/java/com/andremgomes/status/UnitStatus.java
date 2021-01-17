package com.andremgomes.status;

public class UnitStatus {
    public final String unitName;
    public final String load;
    public final String active;
    public final String sub;
    public final String description;

    public UnitStatus(String unitName, String load, String active, String sub, String description) {
        this.unitName = unitName;
        this.load = load;
        this.active = active;
        this.sub = sub;
        this.description = description;
    }
}
