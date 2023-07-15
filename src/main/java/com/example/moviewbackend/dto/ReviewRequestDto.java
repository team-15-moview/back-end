package com.example.moviewbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReviewRequestDto {
    private Long user_id; // 임시로 사용자 인증을 위해
    @NotBlank
    private String content;
    @NotNull
    private float star;
}