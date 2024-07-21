package com.api.employeedepartment_onetomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class EmployeeDepartmentOneToManyApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EmployeeDepartmentOneToManyApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
        app.run(args);
    }

    private static String getPort() {
        String port = System.getenv("PORT");
        if (port == null || port.isEmpty()) {
            return "8080";
        }
        return port;
    }

}
