package com.dh.catalog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

	private final CatalogController catalogService;

	public CatalogController(CatalogController catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/online/{genre}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<GetGenreResponse>getGenreResponseOnline(@PathVariable String genre) {
		return ResponseEntity.ok(catalogService.getGenreResponse(genre));
	}

	@GetMapping("/online/{genre}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<GetGenreResponse>getGenreResponseOffline(@PathVariable String genre) {
		return ResponseEntity.ok(catalogService.getGenreResponse(genre));
	}











	/*private final MovieServiceClient movieServiceClient;
	private final SeriesServiceClient seriesServiceClient;*/

	/*public CatalogController(MovieServiceClient movieServiceClient,SeriesServiceClient seriesServiceClient) {
		this.movieServiceClient = movieServiceClient;
		this.seriesServiceClient =seriesServiceClient;}*/

	/*@GetMapping("/movies/{genre}")
	@ResponseStatus(code = HttpStatus.OK)
	ResponseEntity<List<MovieEntityDto>> getByGenre(@PathVariable String genre) {
		return ResponseEntity.ok(movieServiceClient.getMovieByGenre(genre));
	}*/

	/*public CatalogController(SeriesServiceClient seriesServiceClient) {
		this.seriesServiceClient = seriesServiceClient;}*/


	/*@GetMapping("/series/{genre}")
	ResponseEntity<List<SeriesEntityDto>> getGenre(@PathVariable String genre) {
		return ResponseEntity.ok(seriesServiceClient.getSeriesByGenre(genre));
	}*/



}
