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

    /**
     * 리뷰 작성
     * 병합후  @AuthenticationPrincipal UserDetailsImpl userDetails 추가하기!
     * @param movieId 영화 id
     * @param requestDto 리뷰 요청 dto
     * @return ResponseEntity<ReviewResponseDto> 반환
     */
    @PostMapping
    public ResponseEntity<ReviewResponseDto> createReview(@PathVariable Long movieId,
                                                          @RequestBody ReviewRequestDto requestDto) {
        return reviewService.createReview(movieId, requestDto);
    }

    /**
     * 리뷰 수정
     * @param movieId 영화 id
     * @param id 리뷰 id
     * @param requestDto 리뷰 요청 dto
     * @return ResponseEntity<ReviewResponseDto> 반환
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> updateReview(@PathVariable Long movieId,
                                                          @PathVariable Long id,
                                                          @RequestBody ReviewRequestDto requestDto) {
        return reviewService.updateReview(movieId, id, requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponseDto> deleteReview(@PathVariable Long movieId,
                                                          @PathVariable Long id) {
        return reviewService.deleteReview(movieId, id);
    }
}
