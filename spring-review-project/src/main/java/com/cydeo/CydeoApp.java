package com.cydeo;

import com.cydeo.config.AppConfig;
import com.cydeo.model.Employee;
import com.cydeo.service.Salary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("John");
        employee1.setDepartment("IT");
        employee1.setHourlyRate(65);

        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        Salary salary = container.getBean(Salary.class);
        salary.calculateRegularSalary(employee1);

    }
}
