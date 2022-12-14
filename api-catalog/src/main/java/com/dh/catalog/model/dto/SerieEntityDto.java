package com.dh.catalog.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SerieEntityDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String serieId;

    private String name;

    private String genre;

    private List<SeasonEntityDto> seasonsEntityDto = new ArrayList<>();
}
