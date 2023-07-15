package com.example.moviewbackend.repository;

import com.example.moviewbackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
