package com.smartclinic.clinic.service;

import com.smartclinic.clinic.dto.CreateClinicConfigurationRequest;
import com.smartclinic.clinic.entity.Clinic;
import com.smartclinic.clinic.entity.ClinicConfiguration;
import com.smartclinic.clinic.repository.ClinicConfigurationRepository;
import com.smartclinic.clinic.repository.ClinicRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClinicConfigurationService {

    private final ClinicRepository clinicRepository;
    private final ClinicConfigurationRepository configRepository;

    public ClinicConfigurationService(
            ClinicRepository clinicRepository,
            ClinicConfigurationRepository configRepository) {

        this.clinicRepository = clinicRepository;
        this.configRepository = configRepository;
    }

    public ClinicConfiguration configureClinic(
            UUID clinicId,
            CreateClinicConfigurationRequest request) {

        Clinic clinic = clinicRepository
                .findById(clinicId)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        ClinicConfiguration config = new ClinicConfiguration();

        config.setClinic(clinic);
        config.setSlotDurationMinutes(request.getSlotDurationMinutes());
        config.setBufferTimeMinutes(request.getBufferTimeMinutes());
        config.setMaxPatientsPerDay(request.getMaxPatientsPerDay());
        config.setStartTime(request.getStartTime());
        config.setEndTime(request.getEndTime());
        config.setWorkingDays(request.getWorkingDays());

        return configRepository.save(config);
    }
}
