package com.andremgomes.register.company;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Client extends PanacheEntity {

    public String name;

    @Lob
    @Column(length = 20_000)
    public byte[] icon;

    public ClientDTO toDTO(){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.name = this.name;
        return clientDTO;
    }

}
