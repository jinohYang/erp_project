package com.jino.erp_project.service;

import com.jino.erp_project.domain.entity.User;
import com.jino.erp_project.dto.UserSignupRequest;
import com.jino.erp_project.repository.UserRepository;
import com.jino.erp_project.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(UserSignupRequest req) {
        User user = User.builder()
                .username(req.getUsername())
                .password(passwordEncoder.encode(req.getPassword()))
                .email(req.getEmail())
                .role("EMPLOYEE")
                .build();
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        // 토큰 발급
        return jwtTokenProvider.createToken(user.getUsername(), user.getRole());
    }
}
