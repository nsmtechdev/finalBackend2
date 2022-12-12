package com.dh.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeriesRepository extends MongoRepository<Series,String> {
}
