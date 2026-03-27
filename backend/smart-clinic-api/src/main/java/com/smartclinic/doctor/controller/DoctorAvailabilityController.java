package com.smartclinic.doctor.controller;

import com.smartclinic.doctor.dto.CreateDoctorAvailabilityRequest;
import com.smartclinic.doctor.entity.DoctorAvailability;
import com.smartclinic.doctor.service.DoctorAvailabilityService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/doctor-availability")
public class DoctorAvailabilityController {

    private final DoctorAvailabilityService service;

    public DoctorAvailabilityController(
            DoctorAvailabilityService service) {

        this.service = service;
    }

    @PreAuthorize("hasRole('CLINIC_ADMIN')")
    @PostMapping("/{doctorId}")
    public DoctorAvailability addAvailability(
            @PathVariable UUID doctorId,
            @Valid @RequestBody CreateDoctorAvailabilityRequest request) {

        return service.addAvailability(doctorId, request);
    }
}