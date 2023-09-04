package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all courses by category
    //is there any method in JpaRepository? No, it has methods finding by Id
    //3 options: Derive Query, JPQL, Named queries
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with a provided name exists. return true if course exists
    boolean existsByName(String name);

    //returns the count of courses for the provided category
    int countCourseByCategory(String course);

    //find all courses that start with the provided course name
    Optional<Course> findByNameStartingWith(String name);

    //find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);


    //(JPQL) Named Parameters
    @Query("SELECT c FROM Course c WHERE c.category = :category AND c.rating > :rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);
}
