package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private Long id;
    private String firstName;   // "first_name" in table column name
    private String lastName;
    private String email;
}
