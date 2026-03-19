package com.smartclinic.clinic.service;

import com.smartclinic.clinic.dto.CreateClinicRequest;
import com.smartclinic.clinic.entity.Clinic;
import com.smartclinic.clinic.repository.ClinicRepository;
import com.smartclinic.user.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;
    private final UserService userService;

    public ClinicService(ClinicRepository clinicRepository,
                         UserService userService) {
        this.clinicRepository = clinicRepository;
        this.userService = userService;
    }

    @Transactional
    public Clinic createClinic(CreateClinicRequest request) {

        // 1. Create Clinic
        Clinic clinic = new Clinic();
        clinic.setName(request.getClinicName());
        clinic.setEmail(request.getEmail());
        clinic.setPhone(request.getPhone());

        Clinic savedClinic = clinicRepository.save(clinic);

        // 2. Create Admin User
        userService.createAdminUser(
                savedClinic,
                request.getEmail(),
                request.getPassword()
        );

        return savedClinic;
    }
}