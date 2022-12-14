package com.dh.catalog.repository;

import com.dh.catalog.model.MovieEntity;
import com.dh.catalog.model.dto.MovieEntityDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
public interface MovieRepository extends MongoRepository<MovieEntity, Long> {

    List<MovieEntityDto> findByGenre(@PathVariable(value = "genre") String genre);
}
