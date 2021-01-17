package com.andremgomes.register.application;

import com.andremgomes.register.application.RegisterRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }


}
