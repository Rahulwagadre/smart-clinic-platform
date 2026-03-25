package com.smartclinic.clinic.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalTime;

public class CreateClinicConfigurationRequest {

    @NotNull
    private Integer slotDurationMinutes;

    @NotNull
    private Integer bufferTimeMinutes;

    @NotNull
    private Integer maxPatientsPerDay;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    @NotNull
    @Pattern(
            regexp = "^(MON|TUE|WED|THU|FRI|SAT|SUN)(,(MON|TUE|WED|THU|FRI|SAT|SUN))*$",
            message = "Invalid working days format"
    )
    private String workingDays;

    public CreateClinicConfigurationRequest() {
    }

    public CreateClinicConfigurationRequest(Integer slotDurationMinutes, Integer bufferTimeMinutes, Integer maxPatientsPerDay, LocalTime startTime, LocalTime endTime, String workingDays) {
        this.slotDurationMinutes = slotDurationMinutes;
        this.bufferTimeMinutes = bufferTimeMinutes;
        this.maxPatientsPerDay = maxPatientsPerDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workingDays = workingDays;
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
}