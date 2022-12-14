package com.dh.catalog.model;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;

//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChapterEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private String chapterId;

    private String name;

    private Integer number;

    private String urlStream;

}
