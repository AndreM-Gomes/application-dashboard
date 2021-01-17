package com.andremgomes.register.company;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;

public class ClientCreateDTO {

    @FormParam("name")
    public String name;

    private byte[] icon;

    public byte[] getIcon() {
        return icon;
    }

    @FormParam("icon")
    @PartType("application/octet-stream")
    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public Client toCompany(){
        Client client = new Client();
        client.name = this.name;
        client.icon = this.icon;
        return client;
    }
}
