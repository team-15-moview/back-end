package com.example.moviewbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReviewRequestDto {
    private Long user_id; // 병합전이라 임시로
    @NotBlank
    private String content;
    @NotNull
    private float star;
}
