package com.example.moviewbackend.controller;


import com.example.moviewbackend.dto.ApiResponseDto;
import com.example.moviewbackend.dto.SignupRequestDto;
import com.example.moviewbackend.security.UserDetailsImpl;
import com.example.moviewbackend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDto> signUp(@Valid @RequestBody SignupRequestDto requestDto) {
        userService.signup(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDto("회원가입 성공"));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseDto> withdrawal(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        userService.withdrawal(userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto("회원탈퇴 성공"));
    }

}