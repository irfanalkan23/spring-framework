package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigApp {

    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }

    //if we create more than one bean for the same class, we have two solution options
//    @Bean(name = "p1")        // 1st option: (name="someName")
    @Bean
    @Primary                    // 2nd option: @Primary
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }

//    @Bean(name = "p2")
    @Bean
    PartTimeMentor partTimeMentor2(){
        return new PartTimeMentor();
    }
}
