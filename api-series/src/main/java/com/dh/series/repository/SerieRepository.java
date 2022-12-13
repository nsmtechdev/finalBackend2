package com.dh.series.repository;

import com.dh.series.model.SerieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends MongoRepository<SerieEntity, String> {

    List<SerieEntity> findByGenre(String genre);
    
}
