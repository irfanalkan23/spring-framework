package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movie extends BaseEntity{

    private Integer duration;
    private String name;
    private BigDecimal price;
    @Column(columnDefinition = "TIMESTAMP") //TIMESTAMP or DATE?
    private LocalDate releaseDate;
    @Enumerated(EnumType.STRING)
    private MovieState state;
    @Column(columnDefinition = "text")
    private String summary;
    @Enumerated(EnumType.STRING)
    private MovieType type;
}
