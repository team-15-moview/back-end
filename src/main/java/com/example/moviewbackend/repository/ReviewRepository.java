package com.example.moviewbackend.repository;

import com.example.moviewbackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByMovieIdAndId(Long movieId, Long id);
}
