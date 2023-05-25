package com.cydeo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan scans only the package it belongs. So, tell the base package
//@ComponentScan(basePackages = "com.cydeo")
@ComponentScan(basePackages = {"com.cydeo.proxy","com.cydeo.service", "com.cydeo.repository"})
public class ProjectConfig {
}
