package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie extends BaseEntity{

    private Integer duration;
    private String name;
    private BigDecimal price;
    @Column(columnDefinition = "DATE") //TIMESTAMP or DATE?
    private LocalDate releaseDate;
    @Enumerated(EnumType.STRING)
    private MovieState state;
    @Column(columnDefinition = "text")
    private String summary;
    @Enumerated(EnumType.STRING)
    private MovieType type;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel", //because, ER Table name was MovieGenreRel. default was movie_genre_list
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;  //Set<> is better in ManyToMany for performance

    @Override
    public String toString() {
        return "Movie{" +
                "duration=" + duration +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", state=" + state +
                ", summary='" + summary + '\'' +
                ", type=" + type +
                '}';
    }

//we don't need this constructor since we're not using bootstrap.
//    public Movie(Integer duration, String name, BigDecimal price, LocalDate releaseDate, MovieState state, String summary, MovieType type) {
//        this.duration = duration;
//        this.name = name;
//        this.price = price;
//        this.releaseDate = releaseDate;
//        this.state = state;
//        this.summary = summary;
//        this.type = type;
//    }
}
