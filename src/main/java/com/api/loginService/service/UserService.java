package com.api.loginService.service;

import com.api.loginService.dtos.NewUserResponse;
import com.api.loginService.dtos.NewUserRequest;

import com.api.loginService.dtos.UserLoginRequest;
import com.api.loginService.model.UserModel;
import com.api.loginService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    public UserModel findUserByLogin(UserLoginRequest userRequest) {
        var login = userRepository.findByLogin(userRequest.getLogin()).orElseThrow();

        return login;
    }

    public NewUserResponse createUser(NewUserRequest newUserRequest) {
        NewUserResponse newUserResponse = new NewUserResponse();
        var newUser = userRepository.findByCpf(newUserRequest).orElseThrow();
        String passwordEncrypted = encode(newUserRequest.getPassword());
        System.out.println(passwordEncrypted);
        newUser.setPassword(passwordEncrypted);
        userRepository.save(newUser);
        BeanUtils.copyProperties(newUser,newUserResponse);
        return newUserResponse;
    }

   public String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
