package com.example.moviewbackend.service;

import com.example.moviewbackend.exception.CustomResponseException;
import com.example.moviewbackend.dto.ReviewRequestDto;
import com.example.moviewbackend.dto.ReviewResponseDto;
import com.example.moviewbackend.entity.Movie;
import com.example.moviewbackend.entity.Review;
import com.example.moviewbackend.entity.User;
import com.example.moviewbackend.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .movieTitle(movie.getTitle())
                .reviewId(review.getId())
                .nickname(user.getNickname())
                .content(review.getContent())
                .star(review.getStar())
                .build();

        return ResponseEntity.status(201).body(responseDto);
    }

    @Transactional
    public ResponseEntity<ReviewResponseDto> updateReview(Long movieId, Long id, ReviewRequestDto requestDto) {
        // 해당 리뷰가 존재하는지 확인
        Review review = findReview(movieId, id);

        // 작성자가 맞는지 확인
        if (!review.getUser().getId().equals(requestDto.getUser_id())) { // 임시로 아이디로 확인
            throw new CustomResponseException(HttpStatus.FORBIDDEN, "작성자만 수정할 수 있습니다.");
        }

        // 엔티티 업데이트
        review.update(requestDto);

        ReviewResponseDto responseDto = ReviewResponseDto.builder()
                .movieTitle(review.getMovie().getTitle())
                .reviewId(review.getId())
                .nickname(review.getUser().getNickname())
                .content(review.getContent())
                .star(review.getStar())
                .build();

        return ResponseEntity.status(200).body(responseDto);
    }

    protected Review findReview(Long movieId, Long id) {
        return reviewRepository.findByMovieIdAndId(movieId, id).orElseThrow(() ->
                new IllegalArgumentException("선택한 리뷰가 존재하지 않습니다.")
        );
    }
}