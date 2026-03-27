package com.smartclinic.appointment.repository;

import com.smartclinic.appointment.entity.AppointmentSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AppointmentSlotRepository extends JpaRepository<AppointmentSlot, UUID> {
    List<AppointmentSlot> findAppointmentSlotByDoctorIdAndSlotDate(UUID doctorId, LocalDate slotDate);
}
