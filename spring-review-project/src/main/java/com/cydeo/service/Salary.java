package com.cydeo.service;

import com.cydeo.model.Employee;
import com.cydeo.repository.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Salary {


    public final EmployeeRepository employeeRepository;
    public final HoursRepository hoursRepository;

    public Salary(EmployeeRepository employeeRepository, @Qualifier("REGULAR") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularSalary(Employee employee){
        System.out.println(employeeRepository.getHourlyRate(employee)*hoursRepository.getHours(employee));
    }
}
