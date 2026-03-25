package com.smartclinic.clinic.controller;

import com.smartclinic.clinic.dto.CreateClinicConfigurationRequest;
import com.smartclinic.clinic.entity.ClinicConfiguration;
import com.smartclinic.clinic.service.ClinicConfigurationService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clinic-configurations")
public class ClinicConfigurationController {

    private final ClinicConfigurationService service;

    public ClinicConfigurationController(
            ClinicConfigurationService service) {

        this.service = service;
    }

    @PreAuthorize("hasRole('CLINIC_ADMIN')")
    @PostMapping("/{clinicId}")
    public ClinicConfiguration configureClinic(
            @PathVariable UUID clinicId,
            @Valid @RequestBody CreateClinicConfigurationRequest request) {

        return service.configureClinic(clinicId, request);
    }
}