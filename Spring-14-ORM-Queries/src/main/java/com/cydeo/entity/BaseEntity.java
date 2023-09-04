package com.cydeo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)   //not using this. because in the tables, we see id
    private Long id;
}
