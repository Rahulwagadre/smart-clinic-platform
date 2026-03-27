CREATE TABLE appointment_slots (
    id UUID PRIMARY KEY,

    doctor_id UUID NOT NULL,

    slot_date DATE NOT NULL,

    start_time TIME NOT NULL,
    end_time TIME NOT NULL,

    booked BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP,

    CONSTRAINT fk_slot_doctor
        FOREIGN KEY (doctor_id)
        REFERENCES doctors(id)
);