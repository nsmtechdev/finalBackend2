package com.dh.movie.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Movie")
public class Movie implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    @Column(name = "GENRE", nullable = false, length = 50)
    private String genre;
    @Column(name = "URLSTREAM", nullable = false, length = 50)
    private String urlStream;

}
