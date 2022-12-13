package com.dh.catalog.client;

import com.dh.catalog.model.dto.MovieEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="api-movie")
/*@LoadBalancerClient(name = "api-movie", configuration = LoadBalancerConfiguration.class)*/
public interface MovieFeign {

	@GetMapping("/api/v1/movies/{genre}")
	List<MovieEntityDto> getMovieByGenre(@PathVariable (value = "genre") String genre);



}