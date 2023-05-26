package com.cydeo.stereotype_annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan    --> error --> AppConfig is config package there is no class with @Component
// POJOs with @Component are in another package
@ComponentScan(basePackages = "com.cydeo.stereotype_annotations")
public class AppConfig {
}
