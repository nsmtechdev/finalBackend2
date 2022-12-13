package com.dh.catalog.controller;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetGenreResponseMovieSeriesDto {
    private List<GetGenreResponse.MovieEntityDto> movies=new ArrayList<>();
    private List<GetGenreResponse.SeriesEntityDto> series=new ArrayList<>();


}
