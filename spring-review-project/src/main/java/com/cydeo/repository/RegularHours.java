package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("REGULAR")
public class RegularHours implements HoursRepository{
    @Override
    public int getHours(Employee employee) {
        return 40;
    }
}
