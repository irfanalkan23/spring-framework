package com.cydeo.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // if I will use @Bean, I need to create methods that return objects
    @Bean
    public FullTimeEmployee fullTimeEmployee(){
        return new FullTimeEmployee();
    }

    @Bean
    public PartTimeEmployee partTimeEmployee(){
        return new PartTimeEmployee();
    }
}
