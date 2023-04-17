package com.library.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;

/**
 * @author tsk
 * @create 2023/4/4 - 10:16
 */
@SpringBootConfiguration
public class AutoStartProjectInDefaultBrowser implements CommandLineRunner {
    @Override
    public void run(String ... args) throws Exception {
        try {
            Runtime.getRuntime().exec("cmd /c start http://localhost/pages/logins.html");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
