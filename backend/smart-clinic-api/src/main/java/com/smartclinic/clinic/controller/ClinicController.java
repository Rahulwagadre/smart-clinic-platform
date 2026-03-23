package com.smartclinic.clinic.controller;

import com.smartclinic.clinic.dto.CreateClinicRequest;
import com.smartclinic.clinic.entity.Clinic;
import com.smartclinic.clinic.service.ClinicService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinics")
public class ClinicController {

    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PreAuthorize("hasRole('CLINIC_ADMIN')")
    @PostMapping
    public Clinic createClinic(@Valid @RequestBody CreateClinicRequest request) {
        return clinicService.createClinic(request);
    }
}