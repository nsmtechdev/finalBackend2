package com.dh.catalog.client;
//
import com.dh.catalog.model.dto.SerieEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
//@LoadBalancerClient(name = "api-movie", configuration = LoadBalancerConfiguration.class)
@FeignClient(name="api-series")
public interface SeriesFeign {

    @GetMapping("/api/v1/series/{genre}")
    List<SerieEntityDto> getSeriesByGenre(@PathVariable(value = "genre") String genre);
}

