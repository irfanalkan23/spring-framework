package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "employees")
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    private int salary;

    //@OneToOne: telling Hibernate the relationship bw two objects (tables)
    //cascade : telling Hibernate to persist also the child (department) when creating employee
    @OneToOne(cascade = CascadeType.ALL)
    //actually, this could be ManyToOne, because many employees belong to one department
//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    //REMOVE is normally never used in companies. just change the status (0,1)
    @JoinColumn(name = "department_id")     //custom column name. we don't need this, because default is the same
    private Department department;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    private Region region;

    public Employee(String firstName, String lastName, String email, LocalDate hireDate, int salary, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
//        this.department = department;
        this.salary = salary;
        this.gender = gender;
//        this.region = region;
    }
}
