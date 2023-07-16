package com.example.moviewbackend.service;

import com.example.moviewbackend.dto.LoginRequestDto;
import com.example.moviewbackend.dto.SignupRequestDto;
import com.example.moviewbackend.entity.User;
import com.example.moviewbackend.jwt.JwtUtil;
import com.example.moviewbackend.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    public void signup(SignupRequestDto requestDto) {
        String email = requestDto.getEmail();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String nickname = requestDto.getNickname();

        //이메일 중복 확인
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
        //닉네임 중복 확인
        if(userRepository.findByNickname(nickname).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 닉네임입니다.");
        }

        User user = new User(email, password);
        userRepository.save(user);
    }

    public void withdrawal(Long id, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims = jwtUtil.getUserInfoFromToken(token);
        String email = claims.getSubject();
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 아닙니다.")
        );

        if(!user.getId().equals(id)) {
            throw new IllegalStateException("You can't delete another user's account!");
        }
        userRepository.delete(user);

        //댓글, 리뷰, 좋아요 삭제 필요


    }

    public void login(LoginRequestDto requestDto) {
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        //사용자 확인 (username 이 없는 경우)
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        //비밀번호 확인 (password 가 다른 경우)
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        jwtUtil.createToken(email);
    };
}