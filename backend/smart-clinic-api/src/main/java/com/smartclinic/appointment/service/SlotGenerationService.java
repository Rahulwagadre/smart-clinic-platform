package com.smartclinic.appointment.service;

import com.smartclinic.appointment.entity.AppointmentSlot;
import com.smartclinic.clinic.entity.ClinicConfiguration;
import com.smartclinic.clinic.repository.ClinicConfigurationRepository;
import com.smartclinic.doctor.entity.Doctor;
import com.smartclinic.doctor.entity.DoctorAvailability;
import com.smartclinic.doctor.repository.DoctorAvailabilityRepository;
import com.smartclinic.doctor.repository.DoctorRepository;
import com.smartclinic.appointment.repository.AppointmentSlotRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class SlotGenerationService {

    private final DoctorRepository doctorRepository;
    private final DoctorAvailabilityRepository availabilityRepository;
    private final ClinicConfigurationRepository configRepository;
    private final AppointmentSlotRepository slotRepository;

    public SlotGenerationService(
            DoctorRepository doctorRepository,
            DoctorAvailabilityRepository availabilityRepository,
            ClinicConfigurationRepository configRepository,
            AppointmentSlotRepository slotRepository) {

        this.doctorRepository = doctorRepository;
        this.availabilityRepository = availabilityRepository;
        this.configRepository = configRepository;
        this.slotRepository = slotRepository;
    }

    public void generateSlots(UUID doctorId, LocalDate date) {

        Doctor doctor = doctorRepository
                .findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        ClinicConfiguration config =
                configRepository
                        .findByClinicId(
                                doctor.getClinic().getId())
                        .orElseThrow();

        List<DoctorAvailability> availabilityList =
                availabilityRepository
                        .findByDoctorId(doctorId);

        DayOfWeek day = date.getDayOfWeek();

        DoctorAvailability availability =
                availabilityList.stream()
                        .filter(a -> a.getDayOfWeek() == day)
                        .findFirst()
                        .orElseThrow();

        generateTimeSlots(
                doctor,
                availability,
                config,
                date
        );
    }

    private void generateTimeSlots(
            Doctor doctor,
            DoctorAvailability availability,
            ClinicConfiguration config,
            LocalDate date) {

        LocalTime start = availability.getStartTime();
        LocalTime end = availability.getEndTime();

        LocalTime breakStart = availability.getBreakStart();
        LocalTime breakEnd = availability.getBreakEnd();

        int slotDuration = config.getSlotDurationMinutes();
        int buffer = config.getBufferTimeMinutes();

        while (start.plusMinutes(slotDuration).isBefore(end)
                || start.plusMinutes(slotDuration).equals(end)) {

            LocalTime slotEnd =
                    start.plusMinutes(slotDuration);

            boolean inBreak =
                    breakStart != null &&
                            start.isAfter(breakStart) &&
                            start.isBefore(breakEnd);

            if (!inBreak) {

                AppointmentSlot slot =
                        new AppointmentSlot();

                slot.setDoctor(doctor);
                slot.setSlotDate(date);
                slot.setStartTime(start);
                slot.setEndTime(slotEnd);

                slotRepository.save(slot);
            }

            start = slotEnd.plusMinutes(buffer);
        }
    }
}