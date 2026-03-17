package com.smartclinic.clinic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "clinics")
public class Clinic {
    @Id
    private UUID id;

    @NotNull(message = "Clinic name can not be empty")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Clinic email can not be empty")
    @Column(nullable = false)
    private String email;

    @NotNull(message = "Clinic phone number can not be empty")
    @Column(nullable = false)
    private String phone;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Clinic() {
    }

    public Clinic(UUID id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @PrePersist
    public void PrePersist() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void PreUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
