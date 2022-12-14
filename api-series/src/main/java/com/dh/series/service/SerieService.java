package com.dh.series.service;

import com.dh.series.events.NewSerieEventProducer;
import com.dh.series.model.SerieEntity;

import com.dh.series.repository.SerieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeasonService  {

    private final SerieRepository serieRepository;
    private final NewSerieEventProducer newSerieEventProducer;

    public SeasonService(SerieRepository serieRepository, NewSerieEventProducer newSerieEventProducer) {
        this.serieRepository = serieRepository;
        this.newSerieEventProducer = newSerieEventProducer;
    }

    public List<SerieEntity> getByGenre(String genre) {
        return serieRepository.findByGenre(genre);
    }
    public SerieEntity save(SerieEntity serie) {
        newSerieEventProducer.execute(serie);
        return serieRepository.save(serie);
    }




}
