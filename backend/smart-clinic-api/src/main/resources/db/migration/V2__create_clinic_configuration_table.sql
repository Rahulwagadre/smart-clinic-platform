CREATE TABLE clinic_configurations (
    id UUID PRIMARY KEY,

    clinic_id UUID NOT NULL UNIQUE,

    slot_duration_minutes INTEGER NOT NULL,
    buffer_time_minutes INTEGER NOT NULL,
    max_patients_per_day INTEGER NOT NULL,

    start_time TIME NOT NULL,
    end_time TIME NOT NULL,

    working_days VARCHAR(50) NOT NULL,

    created_at TIMESTAMP,
    updated_at TIMESTAMP,

    CONSTRAINT fk_clinic_config
       FOREIGN KEY (clinic_id)
           REFERENCES clinics(id)
);