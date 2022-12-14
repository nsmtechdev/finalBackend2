package com.dh.catalog.Service;

import com.dh.catalog.client.MovieFeign;
import com.dh.catalog.client.SeriesFeign;
import com.dh.catalog.repository.MovieRepository;
import com.dh.catalog.repository.SeriesRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CatalogService {

    private final MovieFeign movieFeign;
    private final SeriesFeign seriesFeign;

    private final MovieRepository movieRepository;
    private final SeriesRepository serieRepository;


    public CatalogService(MovieFeign movieFeign, SeriesFeign seriesFeign, MovieRepository movieRepository, SeriesRepository serieRepository) {
        this.movieFeign = movieFeign;
        this.seriesFeign = seriesFeign;
        this.movieRepository = movieRepository;
        this.serieRepository = serieRepository;
    }
    @Retry(name = "retryMovieFeign")
    @CircuitBreaker(name = "movieFeign", fallbackMethod = "callMovieFeignFallBack")
    public List<?> getMovieByGenreOnline(String genre) {
        List response =  movieFeign.getMovieByGenre(genre);
        return response;
    }

    public List<?> callMovieFeignFallBack(String genre, Throwable t) {
        List response =  movieFeign.getMovieByGenre(genre);
         return response;
    }
    @Retry(name = "retrySeriesFeign")
    @CircuitBreaker(name = "seriesFeign", fallbackMethod = "callSeriesFeignFallBack")
     public List<?> getSeriesByGenreOnline(String genre) {
        List response =  seriesFeign.getSeriesByGenre(genre);
        return response;
    }

    public List<?> callSeriesFeignFallBack(String genre, Throwable t) {
        List response =  seriesFeign.getSeriesByGenre(genre);
        return response;
    }

/////Offline!


    public List<?> getMovieRepositoryOffline(String genre) {
        List response =  movieRepository.findByGenre(genre);
        return response;}

    public List<?> getSeriesRepositoryOffline(String genre) {
        List response =  serieRepository.findByGenre(genre);
        return response;}
}
//// Comentario pedido!! para mayor resiliencia implmentamos el retry, asi vuelve a intentar la conexion con el MicoServ !