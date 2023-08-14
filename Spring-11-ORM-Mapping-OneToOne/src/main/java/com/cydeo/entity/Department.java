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

    @OneToOne(mappedBy = "department")  //should match with the field name in the Employee class
                    //means "go to department field (in Employee) for the ownership (foreign key)
                    //if we don't put mappedBy, Hibernate creates FOREIGN KEY for both tables (entities)
    private Employee employee;      //we need this if we want bi-directional relationship
            //if we want to access employee through department (department.employee), we need this

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
