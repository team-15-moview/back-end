package com.example.moviewbackend.controller;


import com.example.moviewbackend.dto.ApiResponseDto;
import com.example.moviewbackend.dto.LoginRequestDto;
import com.example.moviewbackend.dto.SignupRequestDto;
import com.example.moviewbackend.jwt.JwtUtil;
import com.example.moviewbackend.service.KakaoService;
import com.example.moviewbackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final KakaoService kakaoService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDto> signUp(@Valid @RequestBody SignupRequestDto requestDto) {
        userService.signup(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDto("회원가입 성공"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto> withdrawal(@PathVariable Long id, HttpServletRequest request) {
        userService.withdrawal(id, request);

        return ResponseEntity.ok().body(new ApiResponseDto("회원탈퇴 성공"));
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto);

        return ResponseEntity.ok().body(new ApiResponseDto("로그인 성공"));
    }


//    @GetMapping("/user/kakao/callback")
//    public String KakaoLogin(@RequestParam String code, HttpServletResponse response) {
//        String token = kakaoService.kakaoLogin(code);
//
//        Cookie cookie = new Cookie(JwtUtil.AUTHORIZATION_HEADER, token);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//
//        return "redirect:/";
//    }
}