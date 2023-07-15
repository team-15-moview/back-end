package com.example.moviewbackend.repository;

import com.example.moviewbackend.dto.MovieResponseDto;
import com.example.moviewbackend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByOrderByOpenDateDesc();

    List<Movie> findAllByGenre(String genre);
}
