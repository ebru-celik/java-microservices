package com.ebru.repository;

import com.ebru.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthRepository extends JpaRepository<Auth, Long> {

    Boolean existsByUsername(String username);

    Optional<Auth> findOptionalByUsernameAndPassword(String username, String password);

}
