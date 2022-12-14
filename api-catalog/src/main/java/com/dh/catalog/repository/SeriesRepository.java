package com.dh.catalog.repository;

import com.dh.catalog.model.SerieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SeriesRepository extends MongoRepository<SerieEntity,String> {
    List<SerieEntity> findByGenre(String genre);
}
