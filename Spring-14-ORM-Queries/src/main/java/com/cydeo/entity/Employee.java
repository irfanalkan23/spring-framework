package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
public class Employee extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;

//    @ManyToOne(fetch = FetchType.LAZY)
// commented out LAZYs because gets error "Caused by: org.hibernate.LazyInitializationException: could not initialize proxy [com.cydeo.entity.Department#Sports] - no Session"
    @ManyToOne
    private Region region;

//    @ManyToOne(fetch = FetchType.LAZY)  //"Many employees can belong to One department"
    @ManyToOne
    @JoinColumn(name="department")  //data.sql'de column name "department" olduğu için yaptık. default "department_id" olurdu.
    private Department department;
}
