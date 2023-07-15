package com.example.moviewbackend.service;

import com.example.moviewbackend.entity.User;
import com.example.moviewbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    protected User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당하는 사용자가 존재하지 않습니다.")
        );
    }
}
