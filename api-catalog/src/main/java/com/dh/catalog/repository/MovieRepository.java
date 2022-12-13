package com.dh.catalog.repository;

import com.dh.catalog.model.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<MovieEntity, String> {


}
