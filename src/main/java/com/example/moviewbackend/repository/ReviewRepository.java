package com.example.moviewbackend.repository;

import com.example.moviewbackend.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByMovieIdAndIdLessThanOrderByIdDesc(Long movieId, Long lastReviewId, Pageable pageable);
}
