package com.example.moviewbackend.controller;


import com.example.moviewbackend.jwt.JwtUtil;
import com.example.moviewbackend.service.KakaoService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoService kakoService;

    /**
     * 카카오 callback
     * [GET] /oauth/kakao/callback
     */
    @ResponseBody
    @GetMapping("/kakao/callback")
    public String kakaoCallback(@RequestParam String code, HttpServletResponse response) {
        String token = kakoService.kakaoLogin(code);

        Cookie cookie = new Cookie(JwtUtil.AUTHORIZATION_HEADER, token);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/";
    }
}