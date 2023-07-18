package com.example.moviewbackend.dto;

import com.example.moviewbackend.entity.Movie;
import com.example.moviewbackend.entity.Review;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DetailReviewResponseDto {
    private String author;
    private Long reviewId;
    private String content;
    private int likesCount;
    //    private int commentsCount;
    private float star;
    private boolean likeByUser; // 현재 접속자가 좋아요 누른 여부
    private MovieDto movie;

    public DetailReviewResponseDto(Review review, Boolean likeByUser) {
        this.author = review.getUser().getNickname();
        this.likeByUser = likeByUser;
        this.reviewId = review.getId();
        this.content = review.getContent();
        this.likesCount = review.getLikesCount();
        this.star = review.getStar();
        this.movie = new MovieDto(review.getMovie());
    }

    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    static class MovieDto {
        private String title;
        private LocalDate openDate;
        private String director;
        private String thumbnail;

        public MovieDto(Movie movie) {
            this.title = movie.getTitle();
            this.openDate = movie.getOpenDate();
            this.director = movie.getDirector();
            this.thumbnail = movie.getThumbnail();
        }
    }
}
