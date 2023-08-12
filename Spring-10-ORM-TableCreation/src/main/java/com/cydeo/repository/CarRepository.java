package com.cydeo.repository;

import com.cydeo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //not required, actually.
public interface CarRepository extends JpaRepository<Car,Long> {
}
