package com.lsw.onbid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lsw.onbid.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
