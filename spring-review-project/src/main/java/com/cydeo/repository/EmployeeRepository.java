package com.cydeo.repository;

import com.cydeo.model.Employee;

public interface EmployeeRepository {

    int getHourlyRate(Employee employee);
}
