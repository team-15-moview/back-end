package com.example.moviewbackend.service;

import com.example.moviewbackend.dto.MovieResponseDto;
import com.example.moviewbackend.dto.Top5MovieResponseDto;
import com.example.moviewbackend.entity.Movie;
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

    public MovieResponseDto getMovie(Long id) {
        return new MovieResponseDto(findMovie(id));
    }

    public List<MovieResponseDto> getMoviesByGenre(String genre) {
        return movieRepository.findAllByGenre(genre)
                .stream()
                .map(MovieResponseDto::new)
                .toList();
    }

    public List<Top5MovieResponseDto> getTop5Movies() {
        return movieRepository.findTop5ByOrderByStarDesc()
                .stream()
                .map(Top5MovieResponseDto::new)
                .toList();

    }

    protected Movie findMovie(Long id) {
        return movieRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 영화는 존재하지 않습니다.")
        );
    }
}
