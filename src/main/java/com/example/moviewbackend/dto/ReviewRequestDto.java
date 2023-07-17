package com.example.moviewbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReviewRequestDto {
    @NotBlank
    private String content;
    @NotNull
    private float star;
}
