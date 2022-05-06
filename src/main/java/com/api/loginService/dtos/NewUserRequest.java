package com.api.loginService.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Component
public class NewUserRequest {
    private String name;
    private String login;
    private String cpf;
    private String password;

    @JsonIgnore
    private LocalDateTime dateLogin;
}
