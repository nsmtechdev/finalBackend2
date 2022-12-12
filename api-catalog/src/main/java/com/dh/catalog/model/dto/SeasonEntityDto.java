package com.dh.catalog.model.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SeasonEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer seasonId;

    private Integer seasonNumber;

    private List<Chapter> chapters = new ArrayList<>();

}

