package com.dh.catalog.repository;

import com.dh.catalog.model.MovieEntity;
import com.dh.catalog.model.dto.MovieEntityDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<MovieEntity, String> {

    List<MovieEntityDto> findByGenre(String genre);
}
