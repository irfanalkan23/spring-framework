package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?

    //Write a derived query to read a user with an username?

    //Write a derived query to list all users that contain a specific name?

    //Write a derived query to list all users that contain a specific name in the ignore case mode?

    //Write a derived query to list all users with an age greater than a specified age?

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?


    //Write a JPQL query that returns a user read by username?


    //Write a JPQL query that returns all users?


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?

    //Write a native query that returns all users?


    //Write a native query that returns all users in the range of ages?


    //Write a native query to read a user by email?


}