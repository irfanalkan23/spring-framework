package com.cydeo.controller;

import com.cydeo.entity.Genre;
import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieCinemaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    //I'm setting the baseUrl() at top. we could do it directly at the bottom as well.
    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    //this is to learn WebClient (Mono,Flux). using repository directly without service is not good design normally.
    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/flux-movie-cinemas")
    //instead of List<>, use Flux<>. this is asynchronized.
    public Flux<MovieCinema> readAllMovieCinemaFlux(){
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

//    @GetMapping("mono-movie-cinemas/{id}")
//    public Mono<MovieCinema> readById(@PathVariable("id") Long id){
//        return Mono.just(movieCinemaRepository.findById(id).get());
//    }

    //if we need to pass header, status etc --> ResponseEntity
    @GetMapping("mono-movie-cinemas/{id}")
    public ResponseEntity<Mono<MovieCinema>> readById(@PathVariable("id") Long id){
        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
    }

    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre){
        Genre createdGenre = genreRepository.save(genre);
        return Mono.just(createdGenre);
//        return Mono.just(genreRepository.save(genre));
    }

    //Mono --> 0 or 1. Delete -> do not return anything (0)
    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> delteGenre(@PathVariable("id") Long id){
        genreRepository.deleteById(id);
        return Mono.empty();
    }

//    WE CREATED API SO FAR, WE DIDN'T CONSUME! Now, let's consume our own API with WEBCLIENT:
//    --------------------- WEBCLIENT ---------------------------

//    this is a change in the app



    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient(){
        return webClient
                .get()
                .uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class);   //jackson will map to which class? = MovieCinema.class
    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id){
        return webClient
                .get()
                .uri("mono-movie-cinemas/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }

}








