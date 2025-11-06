package com.lsw.onbid.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lsw.onbid.entity.User;
import com.lsw.onbid.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    // 생성자 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User register(User user) {
        return userRepository.save(user);
    }
    public Optional<User> findByUsername(String username) { return userRepository.findByUsername(username); }
}
