package com.example.moviewbackend.service;

import com.example.moviewbackend.dto.ReviewRequestDto;
import com.example.moviewbackend.dto.ReviewResponseDto;
import com.example.moviewbackend.entity.Movie;
import com.example.moviewbackend.entity.Review;
import com.example.moviewbackend.entity.User;
import com.example.moviewbackend.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieService movieService;
    private final UserService userService;

    public ResponseEntity<ReviewResponseDto> createReview(Long movieId, ReviewRequestDto requestDto) {
        // 해당 영화가 있는지 확인
        Movie movie = movieService.findMovie(movieId);

        // 유저 가져오기
        User user = userService.findUser(requestDto.getUser_id());

        // 리뷰 생성
        Review review = new Review(requestDto, user, movie);

        // DB에 저장
        reviewRepository.save(review);

        ReviewResponseDto responseDto = ReviewResponseDto.builder()
                .reviewId(review.getId())
                .content(review.getContent())
                .nickname(user.getNickname())
                .star(review.getStar())
                .build();

        return ResponseEntity.status(201).body(responseDto);
    }
}
