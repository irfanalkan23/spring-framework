package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Data
//@AllArgsConstructor     // we don't add this! because id will be created by PostgreSQL
//instead, we create custom constructor without id
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;

    //constructor without id
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}
