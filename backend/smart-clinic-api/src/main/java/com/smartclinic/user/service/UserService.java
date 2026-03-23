package com.smartclinic.user.service;

import com.smartclinic.clinic.entity.Clinic;
import com.smartclinic.common.security.JwtUtil;
import com.smartclinic.common.security.Role;
import com.smartclinic.user.dto.LoginRequest;
import com.smartclinic.user.dto.LoginResponse;
import com.smartclinic.user.entity.User;
import com.smartclinic.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public boolean existsByEmailAndClinicId(String email, UUID clinicId) {
        return userRepository.existsByEmailAndClinicId(email, clinicId);
    }

    public User createAdminUser(Clinic clinic, String email, String rawPassword) {

        User user = new User();
        user.setClinic(clinic);
        user.setName("Admin");
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(Role.CLINIC_ADMIN);

        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {
        User savedUser = userRepository.findByEmail(request.getEmail())
                                            .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if(!passwordEncoder.matches(request.getPassword(), savedUser.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(savedUser.getId(), savedUser.getEmail(), savedUser.getRole().name());

        LoginResponse response = new LoginResponse(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getRole(),
                token
        );

        return response;
    }

}
