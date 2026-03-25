package com.smartclinic.clinic.repository;

import com.smartclinic.clinic.entity.ClinicConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClinicConfigurationRepository extends JpaRepository<ClinicConfiguration, UUID> {
    Optional<ClinicConfiguration> findByClinicId(UUID clinicId);
}
