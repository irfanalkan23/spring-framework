package com.cydeo.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StringConfig {

    @Bean(name = "String1")
    public String str1(){
        return "Welcome to CydeoApp";
    }

    @Primary
    @Bean
    public String str2(){
        return "Spring Core Practice";
    }
}
