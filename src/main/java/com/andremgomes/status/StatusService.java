package com.andremgomes.status;

import com.andremgomes.register.application.RegisterRepository;
import com.andremgomes.systemd.ApplicationStatus;
import com.andremgomes.systemd.SystemctlRepository;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StatusService {

    private final RegisterRepository registerRepository;
    private final SystemctlRepository systemctlRepository;

    public StatusService(RegisterRepository registerRepository, SystemctlRepository systemctlRepository) {
        this.registerRepository = registerRepository;
        this.systemctlRepository = systemctlRepository;
    }

    public List<ApplicationStatus> getAllApplicationStatus() throws IOException, InterruptedException {
        return this.registerRepository
                .getAll()
                .parallelStream()
                .map(systemctlRepository::findApplicationStatusFromRegister)
                .collect(Collectors.toList());
    }


}
