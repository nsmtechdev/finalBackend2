package com.dh.catalog.Service;

import com.dh.catalog.client.MovieFeign;
import com.dh.catalog.client.SeriesFeign;
import com.dh.catalog.repository.MovieRepository;
import com.dh.catalog.repository.SeriesRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CatalogService {
    private final Map<String, Integer> genre;

       private final MovieRepository movieRepository ;
    private final  SeriesRepository seriesRepository;

    private final MovieFeign movieFeign;
    private final SeriesFeign seriesFeign;

    public CatalogService(MovieRepository movieRepository, SeriesRepository seriesRepository, MovieFeign movieFeign, SeriesFeign seriesFeign) {
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
        this.movieFeign = movieFeign;
        this.seriesFeign = seriesFeign;
        this.genre =new HashMap<>();
       }

    public GetGenreResponse getGenreResponseOnline(String genre) {
        GetGenreResponse response = new GetGenreResponse();
        findAllMoviesBygenre(genre, response);
        findAllSeriesByGenre(genre, response);
        return response;
    }

       @Retry(name = "retryMovie")
    @CircuitBreaker(name = "clientMovie", fallbackMethod = "findAllSeriesFallBack")
    private void findGenreResponse(String genre, GetGenreResponse response) {
        var genreFilter = seriesFeign.getAll().stream().filter(series -> series.getbyGenre().collect(Collectors.toList());
        response.setSeries(SeriesFilter.stream().map(playlist -> {
            GetSugerenciaByPopularidadResponse.PlaylistDto playlistResponse = new GetSugerenciaByPopularidadResponse.PlaylistDto();
            BeanUtils.copyProperties(playlist, playlistResponse);
            return playlistResponse;
        }).collect(Collectors.toList()));
    }
/*
    public void findAllPlaylistFallBack(String popularidad, GetSugerenciaByPopularidadResponse response, Throwable t) {
        var playListFilter = playlistRepositoryMongo.findAll().stream().filter(playlist -> playlist.getMgCount() >= popularidadMg.get(popularidad)).collect(Collectors.toList());
        response.setPlaylist(playListFilter.stream().map(playlist -> {
            GetSugerenciaByPopularidadResponse.PlaylistDto playlistResponse = new GetSugerenciaByPopularidadResponse.PlaylistDto();
            BeanUtils.copyProperties(playlist, playlistResponse);
            return playlistResponse;
        }).collect(Collectors.toList()));
    }

    @Retry(name = "retryMusic")
    @CircuitBreaker(name = "clientMusic", fallbackMethod = "findAllMusicFallBack")
    private void findAllMusicByPopularidad(String popularidad, GetSugerenciaByPopularidadResponse response) {
        var musicsFilter = musicFeign.getAll().stream().filter(music -> music.getMgCount() >= popularidadMg.get(popularidad)).collect(Collectors.toList());
        response.setMusics(musicsFilter.stream().map(music -> {
            GetSugerenciaByPopularidadResponse.MusicDto musicResponse = new GetSugerenciaByPopularidadResponse.MusicDto();
            BeanUtils.copyProperties(music, musicResponse);
            return musicResponse;
        }).collect(Collectors.toList()));
    }

    private void findAllMusicFallBack(String popularidad, GetSugerenciaByPopularidadResponse response, Throwable t) {
        var musicsFilter = musicRepositoryMongo.findAll().stream().filter(music -> music.getMgCount() >= popularidadMg.get(popularidad)).collect(Collectors.toList());
        response.setMusics(musicsFilter.stream().map(music -> {
            GetSugerenciaByPopularidadResponse.MusicDto musicResponse = new GetSugerenciaByPopularidadResponse.MusicDto();
            BeanUtils.copyProperties(music, musicResponse);
            return musicResponse;
        }).collect(Collectors.toList()));
    }

    public GetSugerenciaByPopularidadResponse getSugerenciaByPopularidadOffline(String popularidad) {
        GetSugerenciaByPopularidadResponse response = new GetSugerenciaByPopularidadResponse();
        var musicsFilter = musicRepositoryMongo.findAll().stream().filter(music -> music.getMgCount() >= popularidadMg.get(popularidad)).collect(Collectors.toList());
        response.setMusics(musicsFilter.stream().map(music -> {
            GetSugerenciaByPopularidadResponse.MusicDto musicResponse = new GetSugerenciaByPopularidadResponse.MusicDto();
            BeanUtils.copyProperties(music, musicResponse);
            return musicResponse;
        }).collect(Collectors.toList()));

        var playListFilter = playlistRepositoryMongo.findAll().stream().filter(playlist -> playlist.getMgCount() >= popularidadMg.get(popularidad)).collect(Collectors.toList());
        response.setPlaylist(playListFilter.stream().map(playlist -> {
            GetSugerenciaByPopularidadResponse.PlaylistDto playlistResponse = new GetSugerenciaByPopularidadResponse.PlaylistDto();
            BeanUtils.copyProperties(playlist, playlistResponse);
            return playlistResponse;
        }).collect(Collectors.toList()));
        return response;*/

}
