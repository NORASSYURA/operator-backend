package org.example.operatorbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;

@SpringBootApplication
public class OperatorBackendApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(OperatorBackendApplication.class);

        // Forces Java to bind to 0.0.0.0 so your phone can reach it over Wi-Fi
        app.setDefaultProperties(Collections.singletonMap("server.address", "0.0.0.0"));
        System.setProperty("server.address", "0.0.0.0");
        app.run(args);
    }
}
