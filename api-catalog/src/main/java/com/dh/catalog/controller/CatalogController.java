package com.dh.catalog.controller;

import com.dh.catalog.Service.CatalogService;
import com.dh.catalog.client.MovieFeign;
import com.dh.catalog.client.SeriesFeign;
import com.dh.catalog.repository.MovieRepository;
import com.dh.catalog.repository.SeriesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

	private final MovieFeign movieFeign;
	private final SeriesFeign seriesFeign;
	private final CatalogService catalogService;

	public CatalogController(MovieFeign movieFeign, SeriesFeign seriesFeign, CatalogService catalogService) {
		this.movieFeign = movieFeign;
		this.seriesFeign = seriesFeign;
		this.catalogService = catalogService;
	}



	@GetMapping("/Movie/{genre}")
	@ResponseStatus(code = HttpStatus.OK)
	ResponseEntity<List<?>> getMovieByGenre(@PathVariable String genre){
		return ResponseEntity.ok().body(catalogService.getMovieByGenreOnline(genre));
	}

	@GetMapping("/Series/{genre}")
	@ResponseStatus(code = HttpStatus.OK)
	ResponseEntity<List<?>> getSeriesByGenre(@PathVariable String genre){
		return ResponseEntity.ok().body(catalogService.getSeriesByGenreOnline(genre));
	}

	@GetMapping("/Offline/Movie/{genre}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<?> getMovieRepositoryOffline(String genre) {
		List response =  catalogService.getMovieRepositoryOffline(genre);
		return response;}

	@GetMapping("/Offline/Series/{genre}")
	@ResponseStatus(code = HttpStatus.OK)
	ResponseEntity<List<?>> getSeriesByGenreOffline(@PathVariable String genre){
		return ResponseEntity.ok().body(catalogService.getSeriesRepositoryOffline(genre));
	}
}












