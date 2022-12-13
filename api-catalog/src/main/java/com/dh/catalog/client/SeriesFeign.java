package com.dh.catalog.client;

import com.dh.catalog.model.dto.SeriesEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="api-series")
public interface SeriesFeign {

    @GetMapping("/api/v1/series/{genre}")
    List<SeriesEntityDto> getSeriesByGenre(@PathVariable(value = "genre") String genre);
}
