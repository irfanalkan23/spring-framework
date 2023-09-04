package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
    //TASK 7 Min
    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countMovieCinemaByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findByDateTimeGreaterThan(LocalDateTime dateTime);

    //Write a derived query to find the top 3 expensive movies
    List<Movie> findTop3ByOrderByMoviePriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovie_NameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findByCinema_LocationName(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT mc FROM MovieCinema mc WHERE mc.dateTime > ?1")
    List<MovieCinema> fetchAllWithHigherThanSpecificDate(@Param("dateTime") LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT count(*) FROM movie_cinema WHERE cinema_id = ?1", nativeQuery = true)
    Integer countMovieCinemaByCinemaId(@Param("id") Long cinemaId);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT * FROM movie_cinema mc JOIN cinema c ON mc.cinema_id = c.id JOIN location l ON c.location_id = l.id WHERE l.name = ?1", nativeQuery = true)
    List<MovieCinema> retrieveByLocationName(@Param("name") String name);

}