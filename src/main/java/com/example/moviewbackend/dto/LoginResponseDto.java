package com.example.moviewbackend.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto extends ApiResponseDto {
    private String nickname;

    public LoginResponseDto(String nickname, String msg) {
        super(msg);
        this.nickname = nickname;
    }
}
