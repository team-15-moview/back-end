package com.example.moviewbackend.controller;

import com.example.moviewbackend.dto.CommonResponseDto;
import com.example.moviewbackend.dto.NewReviewRequestDto;
import com.example.moviewbackend.dto.ReviewRequestDto;
import com.example.moviewbackend.dto.ReviewResponseDto;
import com.example.moviewbackend.security.UserDetailsImpl;
import com.example.moviewbackend.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponseDto> createReview(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                          @RequestBody @Valid NewReviewRequestDto requestDto) {
        return reviewService.createReview(userDetails.getUser(), requestDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> updateReview(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                          @PathVariable Long id,
                                                          @RequestBody @Valid ReviewRequestDto requestDto) {
        return reviewService.updateReview(userDetails.getUser(), id, requestDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> getReview(@PathVariable Long id) {
        return reviewService.getReview(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponseDto> deleteReview(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                          @PathVariable Long id) {
        return reviewService.deleteReview(userDetails.getUser(), id);
    }

    @PostMapping("/{id}/likes")
    public ResponseEntity<ReviewResponseDto> like(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                  @PathVariable Long id) {
        return reviewService.like(userDetails.getUser(), id);
    }

    @DeleteMapping("/{id}/likes")
    public ResponseEntity<ReviewResponseDto> dislike(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                     @PathVariable Long id) {
        return reviewService.dislike(userDetails.getUser(), id);
    }
}
