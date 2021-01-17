package com.andremgomes.register.application;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RegisterRepository implements PanacheRepository<ApplicationRegistry> {

    @Transactional
    public List<ApplicationRegistry> getAll(){
        return listAll();
    }
}
