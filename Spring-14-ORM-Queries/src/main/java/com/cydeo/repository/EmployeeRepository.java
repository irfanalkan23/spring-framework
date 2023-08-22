package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Display all employees with email address ' '
    List<Employee> findByEmailIs(String email);

    //Display all employees with first name ' ' and last name ' ', also show all employees with an email address
    List<Employee> findByFirstNameIsAndLastNameIsOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not ' '
//    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with ' '
//    List<Employee> findByLastNameStartingWith(String pattern);

    //Display all employees with salaries higher than ' '
    List<Employee> findBySalaryGreaterThan(Integer salary);

//    //Display all employees with salaries less than ' '
//    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between ' ' and ' '
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to ' ' in order
//    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than ' '
//    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    // ******* JPQL ******* //
    @Query("SELECT e FROM Employee e where e.email = 'amcnee1@google.es' ")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'amcnee1@google.es'")
    Integer getEmployeeSalary();

    //--- Positional Parameters ---
    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);
    //Optional<> --> because, if there is no match, we will get NullPointerException

    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Optional<Employee> getEmployeeDetail(String email, int salary);

}
