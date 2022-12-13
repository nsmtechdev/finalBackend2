package com.dh.series.service;

import com.dh.series.events.NewSeriesEventProducer;
import com.dh.series.model.SerieEntity;
import com.dh.series.model.dto.SerieDto;
import com.dh.series.repository.SerieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeasonService  {

    private final SerieRepository serieRepository;
    private final NewSeriesEventProducer newSerieEventProducer;

    public SeasonService(SerieRepository serieRepository, NewSeriesEventProducer newSerieEventProducer) {
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

/*
    @Override
    public List<SerieEntity> findByGenre(String genre) {
        return serieRepository.findByGenre(genre);
    }

    @Override
    public SerieEntity save(SerieEntity serieEntity) {
        NewSeriesEventProducer.execute(serieEntity);
        return serieRepository.save(serieEntity);
    }*/


}
