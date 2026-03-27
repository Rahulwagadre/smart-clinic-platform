package com.smartclinic.doctor.controller;

import com.smartclinic.doctor.dto.CreateDoctorRequest;
import com.smartclinic.doctor.entity.Doctor;
import com.smartclinic.doctor.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(
            DoctorService doctorService) {

        this.doctorService = doctorService;
    }

    @PreAuthorize("hasRole('CLINIC_ADMIN')")
    @PostMapping("/{clinicId}")
    public Doctor createDoctor(
            @PathVariable UUID clinicId,
            @Valid @RequestBody CreateDoctorRequest request) {

        return doctorService.createDoctor(clinicId, request);
    }
}