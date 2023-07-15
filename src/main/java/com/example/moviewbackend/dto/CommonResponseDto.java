package com.example.moviewbackend.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Getter
@Builder(builderMethodName = "innerBuilder")
public class CommonResponseDto {

    LocalDateTime timestamp;
    HttpStatus status;
    String message;
    String path;


    public static CommonResponseDtoBuilder builder(Integer status, String error) {
        return innerBuilder().timestamp(LocalDateTime.now())
                .status(HttpStatus.valueOf(status))
                .message(error);
    }
    public static CommonResponseDtoBuilder builder(HttpStatus status, String error) {
        return innerBuilder().timestamp(LocalDateTime.now())
                .status(status)
                .message(error);
    }
    public static CommonResponseDtoBuilder builder(HttpStatusCode status, String error) {
        return innerBuilder().timestamp(LocalDateTime.now())
                .status(HttpStatus.valueOf(status.value()))
                .message(error);
    }
}
/*
{
    "timestamp": "2023-07-04T07:47:03.710+00:00",
    "status": 400,
    "message": "Bad Request",
    "path": "/api/posts/1/comment"
}
 */

