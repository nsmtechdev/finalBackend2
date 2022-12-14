package com.dh.catalog.model.dto;

import com.dh.catalog.model.ChapterEntity;
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
public class SeasonEntityDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String seasonId;

    private Integer seasonNumber;

    private List<ChapterEntityDto> chaptersEntityDto = new ArrayList<>();

}

