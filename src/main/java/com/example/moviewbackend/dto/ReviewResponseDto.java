package com.example.moviewbackend.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReviewResponseDto {
    private String movieTitle;
    private Long reviewId;
    private String nickname;
    private String content;
    private int likesCount;
//    private int commentsCount;
    private float star;
}
