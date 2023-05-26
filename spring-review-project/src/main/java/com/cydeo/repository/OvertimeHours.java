package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("OVERTIME")
public class OvertimeHours implements HoursRepository{
    @Override
    public int getHours(Employee employee) {
        return 15;
    }
}
