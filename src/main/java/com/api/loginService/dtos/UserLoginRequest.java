package com.api.loginService.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class UserLoginRequest {
    private String login;
    private String password;
}
