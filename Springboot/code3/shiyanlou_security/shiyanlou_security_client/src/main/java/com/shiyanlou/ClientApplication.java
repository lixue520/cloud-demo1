package com.shiyanlou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.shiyanlou")
public class ClientApplication {
    public static void main( String[] args ) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
