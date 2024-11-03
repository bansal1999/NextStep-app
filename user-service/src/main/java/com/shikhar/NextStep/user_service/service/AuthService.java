package com.shikhar.NextStep.user_service.service;

import com.shikhar.NextStep.user_service.dto.LoginRequestDTO;
import com.shikhar.NextStep.user_service.dto.SignupRequestDTO;
import com.shikhar.NextStep.user_service.dto.UserDTO;
import com.shikhar.NextStep.user_service.entity.User;
import com.shikhar.NextStep.user_service.exception.BadRequestException;
import com.shikhar.NextStep.user_service.exception.ResourceNotFoundException;
import com.shikhar.NextStep.user_service.repository.UserRepository;
import com.shikhar.NextStep.user_service.utils.PasswordUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AuthService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private JWTService jwtService;

    public UserDTO signup(SignupRequestDTO signupRequestDTO) {
        User user = modelMapper.map(signupRequestDTO, User.class);
        user.setPassword(PasswordUtil.hashPassword(signupRequestDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public String login(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Could not find with email: "
                        + loginRequestDTO.getEmail()));

        boolean isMatchedPassword = PasswordUtil.checkPassword(loginRequestDTO.getPassword(), user.getPassword());

        if (!isMatchedPassword) {
            throw new BadRequestException("Invalid email/password combination");
        }
        return jwtService.generateAccessKey(user);
    }
}
