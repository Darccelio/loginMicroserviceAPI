package com.api.loginService.repository;

import com.api.loginService.dtos.NewUserRequest;

import com.api.loginService.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository< UserModel, Long > {

    @Query("select u from usuario_login u where u.login = ?1")
    Optional<UserModel> findByLogin(String login);

    Optional<UserModel> findByCpf(NewUserRequest newUserRequest);


}
