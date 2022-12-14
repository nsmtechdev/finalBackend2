package com.dh.catalog.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SerieEntityDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    private String serieId;

    private String name;

    private String genre;

    private List<SeasonEntityDto> seasonsEntityDto = new ArrayList<>();
}
