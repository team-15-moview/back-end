package com.example.moviewbackend.controller;

import com.example.moviewbackend.dto.ReviewRequestDto;
import com.example.moviewbackend.dto.ReviewResponseDto;
import com.example.moviewbackend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies/{movieId}/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    /**
     * 리뷰 작성
     * @param movieId
     * @param requestDto
     * @return ResponseEntity<ReviewResponseDto> 반환
     */
    @PostMapping
    public ResponseEntity<ReviewResponseDto> createReview(@PathVariable Long movieId,
                                                          @RequestBody ReviewRequestDto requestDto) {
        return reviewService.createReview(movieId, requestDto);
    }

    /**
     * 리뷰 수정
     * @param movieId
     * @param id
     * @param requestDto
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> updateReview(@PathVariable Long movieId,
                                                          @PathVariable Long id,
                                                          @RequestBody ReviewRequestDto requestDto) {
        return reviewService.updateReview(movieId, id, requestDto);
    }
}
