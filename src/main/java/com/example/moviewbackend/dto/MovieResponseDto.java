package com.example.moviewbackend.dto;

import com.example.moviewbackend.entity.Movie;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MovieResponseDto {
    private Long movieId;
    private String title;
    private LocalDate openDate;
    private String director;
    private String genre;
    private String thumbnail;
    private String still;
    private float rate;

    public MovieResponseDto(Movie movie) {
        this.movieId = movie.getId();
        this.title = movie.getTitle();
        this.openDate = movie.getOpenDate();
        this.director = movie.getDirector();
        this.genre = movie.getGenre();
        this.thumbnail = movie.getThumbnail();
        this.still = movie.getStill();
        this.rate = movie.getRate();
    }
}
