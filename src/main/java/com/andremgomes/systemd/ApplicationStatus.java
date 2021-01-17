package com.andremgomes.systemd;

public class ApplicationStatus {
    public String name;
    public boolean enable;
    public boolean active;

    public ApplicationStatus(String name,boolean enable, boolean active) {
        this.name = name;
        this.enable = enable;
        this.active = active;
    }
}
