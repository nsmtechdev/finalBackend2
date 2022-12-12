package com.dh.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {


}
