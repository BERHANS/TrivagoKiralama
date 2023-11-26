package com.berhan.repository;

import com.berhan.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth,Long> {
    Optional<Auth> findOptionalByUserNameAndPassword(String username,String password);

    Optional<Auth> findOptionalByUserName(String username);
}
