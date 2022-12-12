package com.dh.movie.controller;

import com.dh.movie.model.Movie;
import com.dh.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {


    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{genre}")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.save(movie));
    }
    //@PostMapping("/save")
    //@ResponseStatus(code = HttpStatus.CREATED)
    //public ResponseEntity<Long> create(@RequestBody Movie movie) {
       // movieService.save(movie);
        //return ResponseEntity.ok(movie.getName());

    //ResponseEntity<Movie> save(@RequestBody Movie movie) {
      //  return ResponseEntity.ok().body(movieService.save(movie)); }
}
