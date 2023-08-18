package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)  //preferred over @OneToMany. @ManyToMany default is EAGER
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)  //nothing added to the Cinema side. @ManyToMany default is EAGER
    private Cinema cinema;
}
