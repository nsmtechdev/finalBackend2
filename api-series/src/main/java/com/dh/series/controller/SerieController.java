package com.dh.series.controller;

import com.dh.series.model.SerieEntity;
import com.dh.series.service.SeasonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {

    private final SeasonService service;

    public SerieController(SeasonService service) {
        this.service = service;
    }


    //@Retry(name = "retryMusic")
    //@CircuitBreaker(name = "clientMusic", fallbackMethod = "findAllPlaylistFallBack")
    @GetMapping("/{genre}")
    @ResponseStatus(code = HttpStatus.OK)
    private ResponseEntity<List<SerieEntity>> getByGenre(@PathVariable String genre){
        return ResponseEntity.ok(service.getByGenre(genre));
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    private SerieEntity postSeries(@RequestBody SerieEntity serieEntity){
        return service.save(serieEntity);
    }

}