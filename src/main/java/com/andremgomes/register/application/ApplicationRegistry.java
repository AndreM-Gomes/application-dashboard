package com.andremgomes.register.application;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class ApplicationRegistry extends PanacheEntity {

    public String name;
    public String description;

    @Lob
    @Column(length = 20_000)
    public byte[] icon;

    public ApplicationRegistry(){}

    public ApplicationRegistry(String name) {
        this.name = name;
    }
}
