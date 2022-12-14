package com.dh.catalog.model.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ChapterEntityDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String chapterId;

    private String name;

    private Integer number;

    private String urlStream;

}
