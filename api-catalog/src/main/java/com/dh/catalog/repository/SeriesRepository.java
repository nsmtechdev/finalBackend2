package com.dh.catalog.repository;

import com.dh.catalog.model.SeriesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeriesRepository extends MongoRepository<SeriesEntity,String> {
}
