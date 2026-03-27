package com.smartclinic.doctor.service;

import com.smartclinic.doctor.dto.CreateDoctorAvailabilityRequest;
import com.smartclinic.doctor.entity.Doctor;
import com.smartclinic.doctor.entity.DoctorAvailability;
import com.smartclinic.doctor.repository.DoctorAvailabilityRepository;
import com.smartclinic.doctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorAvailabilityService {

    private final DoctorRepository doctorRepository;
    private final DoctorAvailabilityRepository availabilityRepository;

    public DoctorAvailabilityService(
            DoctorRepository doctorRepository,
            DoctorAvailabilityRepository availabilityRepository) {

        this.doctorRepository = doctorRepository;
        this.availabilityRepository = availabilityRepository;
    }

    public DoctorAvailability addAvailability(
            UUID doctorId,
            CreateDoctorAvailabilityRequest request) {

        Doctor doctor = doctorRepository
                .findById(doctorId)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found"));

        boolean exists =
                availabilityRepository
                        .existsByDoctorIdAndDayOfWeek(
                                doctorId,
                                request.getDayOfWeek());

        if (exists) {
            throw new RuntimeException(
                    "Availability already exists for this day");
        }

        DoctorAvailability availability =
                new DoctorAvailability();

        availability.setDoctor(doctor);
        availability.setDayOfWeek(request.getDayOfWeek());
        availability.setStartTime(request.getStartTime());
        availability.setEndTime(request.getEndTime());
        availability.setBreakStart(request.getBreakStart());
        availability.setBreakEnd(request.getBreakEnd());

        return availabilityRepository.save(availability);
    }
}