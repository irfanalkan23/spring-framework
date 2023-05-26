package com.cydeo.bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {

        // how to create Spring container?
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class, StringConfig.class);

        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        ft.createAccount();

        PartTimeEmployee pt = container.getBean(PartTimeEmployee.class);
        pt.createAccount();

        /* Task:
        We need 2 String objects that has
            "Welcome to CydeoApp"
            "Spring Core Practice"
        Print those objects
        Use new config class
         */

        String str1 = container.getBean("String1",String.class);
        System.out.println(str1);

        String str2 = container.getBean(String.class);
        System.out.println(str2);
    }
}
