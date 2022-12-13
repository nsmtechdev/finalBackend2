package com.dh.movie.service;


import com.dh.movie.event.NewMovieEventProducer;
import com.dh.movie.model.Movie;
import com.dh.movie.repository.MovieRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.log4j.Logger;

@Service
public class MovieService {

    final static Logger log = Logger.getLogger(MovieService.class);

    private final MovieRepository movieRepository;
    private final NewMovieEventProducer newMovieEventProducer;

    public MovieService(MovieRepository movieRepository,NewMovieEventProducer newMovieEventProducer) {
        this.movieRepository = movieRepository;
        this.newMovieEventProducer = newMovieEventProducer;
    }

    public List<Movie> findByGenre(String genre) {
        log.info("Todas las peliculas del género "+ genre);
        return movieRepository.findByGenre(genre);
    }
        public Movie save (Movie movie) {
        log.info("Guardando" + movie.getName());
         movieRepository.save(movie);
        newMovieEventProducer.execute(movie);
        return movie;
    }

    public List<Movie> getAllMovies(){
        log.info("Todas las Peliculas");
        return movieRepository.findAll();
    }


}
