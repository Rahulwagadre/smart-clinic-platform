package com.smartclinic.doctor.repository;

import com.smartclinic.doctor.entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

public interface DoctorAvailabilityRepository
        extends JpaRepository<DoctorAvailability, UUID> {

    List<DoctorAvailability> findByDoctorId(UUID doctorId);

    boolean existsByDoctorIdAndDayOfWeek(
            UUID doctorId,
            DayOfWeek dayOfWeek
    );
}