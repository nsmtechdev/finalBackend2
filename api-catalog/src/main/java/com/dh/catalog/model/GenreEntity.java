package com.dh.catalog.model;
import com.dh.catalog.model.dto.MovieEntityDto;
import com.dh.catalog.model.dto.SeriesEntityDto;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenreEntity {
    private String genre;
    private List<MovieEntityDto> movies;
    private List<SeriesEntityDto> series;
}
