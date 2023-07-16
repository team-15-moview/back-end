package com.example.moviewbackend.dto;

import com.example.moviewbackend.entity.UserRoleEnum;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    @Email
    private String email;

    private String password;

    private UserRoleEnum role; // 회원 권한 (ADMIN, USER)

}
