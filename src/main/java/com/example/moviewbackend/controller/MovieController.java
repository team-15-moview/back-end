package com.example.moviewbackend.controller;

import com.example.moviewbackend.dto.MovieResponseDto;
import com.example.moviewbackend.dto.TopMovieResponseDto;
import com.example.moviewbackend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    /**
     * 영화 전체 조회
     * - 개봉일 기준 내림차순
     * @return MovieResponseDto 리스트 반환
     */
    @GetMapping
    public List<MovieResponseDto> getMovies() {
        return movieService.getMovies();
    }

}
