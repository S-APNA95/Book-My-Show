package com.acciojob.bookmyshowapplication.Models;

import com.acciojob.bookmyshowapplication.Enums.Genre;
import com.acciojob.bookmyshowapplication.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table (name ="movies")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column (unique = true)
    private String movieName;
    private double duration;
    private double rating;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private LocalDate releaseDate;

}
