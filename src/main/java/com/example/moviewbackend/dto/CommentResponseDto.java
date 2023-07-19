package com.example.moviewbackend.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentResponseDto {

    private Long reviewId;
    private CommentDto comment;


    // 기본 생성자
    public CommentResponseDto() {
    }

    // 생성자
    public CommentResponseDto(Long reviewId, CommentDto comment) {
        this.reviewId = reviewId;
        this.comment = comment;
    }


}