package com.cydeo.model;

import lombok.Data;

// we don't put @Component because we are not asking Spring to create a Bean
// why? because this information is retrieved from the UI

@Data
public class Employee {

    private String name;
    private String department;
    private int hourlyRate;
}
