package com.smartclinic.clinic.entity;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "clinic_configurations")
public class ClinicConfiguration {

    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "clinic_id", nullable = false, unique = true)
    private Clinic clinic;

    @Column(nullable = false)
    private Integer slotDurationMinutes;

    @Column(nullable = false)
    private Integer bufferTimeMinutes;

    @Column(nullable = false)
    private Integer maxPatientsPerDay;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private String workingDays;
    // Example: "MON,TUE,WED,THU,FRI"

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClinicConfiguration() {
    }

    public ClinicConfiguration(UUID id, Clinic clinic, Integer slotDurationMinutes, Integer bufferTimeMinutes, Integer maxPatientsPerDay, LocalTime startTime, LocalTime endTime, String workingDays) {
        this.id = id;
        this.clinic = clinic;
        this.slotDurationMinutes = slotDurationMinutes;
        this.bufferTimeMinutes = bufferTimeMinutes;
        this.maxPatientsPerDay = maxPatientsPerDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workingDays = workingDays;
    }

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Integer getSlotDurationMinutes() {
        return slotDurationMinutes;
    }

    public void setSlotDurationMinutes(Integer slotDurationMinutes) {
        this.slotDurationMinutes = slotDurationMinutes;
    }

    public Integer getBufferTimeMinutes() {
        return bufferTimeMinutes;
    }

    public void setBufferTimeMinutes(Integer bufferTimeMinutes) {
        this.bufferTimeMinutes = bufferTimeMinutes;
    }

    public Integer getMaxPatientsPerDay() {
        return maxPatientsPerDay;
    }

    public void setMaxPatientsPerDay(Integer maxPatientsPerDay) {
        this.maxPatientsPerDay = maxPatientsPerDay;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}