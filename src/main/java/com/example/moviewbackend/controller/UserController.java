package com.example.moviewbackend.controller;


import com.example.moviewbackend.dto.ApiResponseDto;
import com.example.moviewbackend.dto.CheckRequestDto;
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

    @PostMapping("/check/email")
    public ResponseEntity<ApiResponseDto> checkEmail(@RequestBody CheckRequestDto requestDto) {
        boolean check = userService.isEmailUnique(requestDto.getEmail());
        return check ? ResponseEntity.ok().body(new ApiResponseDto("사용가능한 이메일입니다."))
                : ResponseEntity.ok().body(new ApiResponseDto("중복되는 이메일입니다."));

    }

    @PostMapping("/check/nickname")
    public ResponseEntity<ApiResponseDto> checkNickname(@RequestBody CheckRequestDto requestDto) {
        boolean check = userService.isNicknameUnique(requestDto.getNickname());
        return check ? ResponseEntity.ok().body(new ApiResponseDto("사용가능한 닉네임입니다."))
                : ResponseEntity.ok().body(new ApiResponseDto("중복되는 닉네임입니다."));
    }
}