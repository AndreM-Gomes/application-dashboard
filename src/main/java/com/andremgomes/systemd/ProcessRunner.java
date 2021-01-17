package com.andremgomes.systemd;

import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@ApplicationScoped
public class ProcessRunner {
    public BufferedReader runCommand(String cmd){
        try{
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmd);
            process.waitFor();
            return new BufferedReader(new InputStreamReader(process.getInputStream()));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
