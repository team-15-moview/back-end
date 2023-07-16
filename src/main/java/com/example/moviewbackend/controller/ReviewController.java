package com.example.moviewbackend.controller;

import com.example.moviewbackend.dto.CommonResponseDto;
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

    // 병합후  @AuthenticationPrincipal UserDetailsImpl userDetails 추가하기!
    @PostMapping
    public ResponseEntity<ReviewResponseDto> createReview(@PathVariable Long movieId,
                                                          @RequestBody ReviewRequestDto requestDto) {
        return reviewService.createReview(movieId, requestDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> updateReview(@PathVariable Long movieId,
                                                          @PathVariable Long id,
                                                          @RequestBody ReviewRequestDto requestDto) {
        return reviewService.updateReview(movieId, id, requestDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> getReview(@PathVariable Long movieId,
                                                       @PathVariable Long id) {
        return reviewService.getReview(movieId, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponseDto> deleteReview(@PathVariable Long movieId,
                                                          @PathVariable Long id) {
        return reviewService.deleteReview(movieId, id);
    }
}
