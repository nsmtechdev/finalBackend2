package com.dh.catalog.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "Series")
public class SeriesEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String serieId;

    private String name;

    private String genre;

    private List<SeasonEntity> seasonsEntity = new ArrayList<>();
}
