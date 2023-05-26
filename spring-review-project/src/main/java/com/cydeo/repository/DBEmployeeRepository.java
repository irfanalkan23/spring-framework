package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{

//    Employee emp1;

    // assume we are getting this data from database
    @Override
    public int getHourlyRate(Employee employee) {
//        return emp1.getHourlyRate();
        return employee.getHourlyRate();
    }
}
