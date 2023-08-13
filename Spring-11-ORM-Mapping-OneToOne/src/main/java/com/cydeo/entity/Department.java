package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "departments")
public class Department extends BaseEntity{

    private String department;  //department name
    private String division;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
