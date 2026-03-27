package com.smartclinic.doctor.repository;

import com.smartclinic.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository
        extends JpaRepository<Doctor, UUID> {
    List<Doctor> findByClinicId(UUID clinicId);
}