package com.example.moviewbackend.service;

import com.example.moviewbackend.dto.MovieResponseDto;
import com.example.moviewbackend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public List<MovieResponseDto> getMovies() {
        return movieRepository.findAllByOrderByOpenDateDesc()
                .stream()
                .map(MovieResponseDto::new)
                .toList();
    }
}
