package com.portafolio.blog_api.services;

import com.portafolio.blog_api.entities.User;
import com.portafolio.blog_api.dto.LoginDto;
import com.portafolio.blog_api.dto.RegisterDto;
import com.portafolio.blog_api.repositories.UserRepository;
import com.portafolio.blog_api.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;


@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    public User register(RegisterDto registerDto) {
        User user = new User();
        user.setUsername(registerDto.getUsername());
       
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        return userRepository.save(user);
    }

        public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }
}