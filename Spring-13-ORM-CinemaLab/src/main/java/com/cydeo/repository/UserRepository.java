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
    Optional<User> findByEmail(String email);
    //Optional<> because email is unique and we'll get only one result

    //Write a derived query to read a user with an username?
    Optional<User> findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User> findAllByAccountNameContaining(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findAllByAccount_NameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccount_AgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> fetchByEmailJPQL(@Param("email") String email);

    //Write a JPQL query that returns a user read by username?
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> fetchByUserNameJPQL(@Param("username") String username);

    //Write a JPQL query that returns all users?
    @Query("SELECT u FROM User u")
    List<User> fetchAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "SELECT * FROM user_account ua JOIN account_details ad " +
            "ON ua.account_details_id = ad.id " +
            "WHERE ad.name ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<User> retrieveAllUsersByName(@Param("name") String name);

    //Write a native query that returns all users?
    @Query(value = "SELECT * FROM user_account",nativeQuery = true)
    List<User> retrieveAllUsers();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user_account ua JOIN account_details ad " +
            "ON ua.account_details_id = ad.id " +
            "WHERE ad.age BETWEEN ?1 AND ?2",nativeQuery = true)
    List<User> retrieveAllUsersBetweenAgeRange(@Param("age1") Integer age1,@Param("age2") Integer age2);

    //Write a native query to read a user by email?
    @Query(value = "SELECT * FROM user_account WHERE email = ?1",nativeQuery = true)
    Optional<User> retrieveByEmail(@Param("email") String email);

}