package com.dh.catalog.repository;

import com.dh.catalog.model.MovieEntity;
import com.dh.catalog.model.SeriesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SeriesRepository extends MongoRepository<SeriesEntity,String> {
    List<SeriesEntity> findByGenre(String genre);
}
