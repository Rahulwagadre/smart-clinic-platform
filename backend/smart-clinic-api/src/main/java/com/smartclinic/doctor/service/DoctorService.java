package com.smartclinic.doctor.service;

import com.smartclinic.clinic.entity.Clinic;
import com.smartclinic.clinic.repository.ClinicRepository;
import com.smartclinic.doctor.dto.CreateDoctorRequest;
import com.smartclinic.doctor.entity.Doctor;
import com.smartclinic.doctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ClinicRepository clinicRepository;

    public DoctorService(
            DoctorRepository doctorRepository,
            ClinicRepository clinicRepository) {

        this.doctorRepository = doctorRepository;
        this.clinicRepository = clinicRepository;
    }

    public Doctor createDoctor(
            UUID clinicId,
            CreateDoctorRequest request) {

        Clinic clinic = clinicRepository
                .findById(clinicId)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        Doctor doctor = new Doctor();

        doctor.setClinic(clinic);
        doctor.setName(request.getName());
        doctor.setEmail(request.getEmail());
        doctor.setPhone(request.getPhone());
        doctor.setSpecialization(request.getSpecialization());

        return doctorRepository.save(doctor);
    }
}