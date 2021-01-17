package com.andremgomes.systemd;

import com.andremgomes.register.application.ApplicationRegistry;

import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;

@ApplicationScoped
public class SystemctlRepository {

    private final ProcessRunner processRunner;

    public SystemctlRepository(ProcessRunner processRunner) {
        this.processRunner = processRunner;
    }

    public ApplicationStatus findApplicationStatusFromRegister(ApplicationRegistry applications){
        String name = applications.name;
        BufferedReader isActiveProcessResponse = this.processRunner.runCommand("systemctl is-active " + name);
        String isActive = this.getLinesFromBufferedReader(isActiveProcessResponse);
        BufferedReader isEnabledProcessResponse = this.processRunner.runCommand("systemctl is-enabled " + name);
        String isEnabled = this.getLinesFromBufferedReader(isEnabledProcessResponse);
        return new ApplicationStatus(
                name,
                isActive.equalsIgnoreCase("active")
                ,isEnabled.equalsIgnoreCase("enabled"));
    }

    public String getLinesFromBufferedReader(BufferedReader bufferedReader){
        try{
            String line = "";
            String allLines = "";
            while((line = bufferedReader.readLine())!=null){
                allLines += line;
            }
            return allLines;
        }catch (Exception e){
            return null;
        }
    }
}
