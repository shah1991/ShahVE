package com.ev;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ev.service.ValidatorService;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ev"})
public class ValidatorApp implements CommandLineRunner {

    @Autowired
    private ValidatorService validatorService;

    public static void main(String[] args) {
        SpringApplication.run(ValidatorApp.class, args);
        System.exit(0);
    }

    @Override
    public void run(String... arg0) throws Exception {
        this.validatorService.serviceCall();
    }
    
}

