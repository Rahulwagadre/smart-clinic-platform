package com.smartclinic.user.repository;

import com.smartclinic.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmailAndClinicId(String email, UUID clinicId);
    Optional<User> findByEmail(String email);
}
