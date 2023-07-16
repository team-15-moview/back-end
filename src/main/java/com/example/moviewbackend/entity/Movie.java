package com.example.moviewbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate openDate;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String thumbnail;

    @Column(nullable = false)
    private String still;

    @Column(nullable = false)
    private Float rate;

}
