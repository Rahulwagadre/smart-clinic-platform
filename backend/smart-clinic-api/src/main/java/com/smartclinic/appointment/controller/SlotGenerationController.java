package com.smartclinic.appointment.controller;

import com.smartclinic.appointment.service.SlotGenerationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/slots")
public class SlotGenerationController {

    private final SlotGenerationService service;

    public SlotGenerationController(
            SlotGenerationService service) {

        this.service = service;
    }

    @PreAuthorize("hasRole('CLINIC_ADMIN')")
    @PostMapping("/{doctorId}")
    public void generateSlots(
            @PathVariable UUID doctorId,
            @RequestParam LocalDate date) {

        service.generateSlots(doctorId, date);
    }
}