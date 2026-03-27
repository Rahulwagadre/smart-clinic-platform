CREATE TABLE doctor_availability (
     id UUID PRIMARY KEY,

     doctor_id UUID NOT NULL,

     day_of_week VARCHAR(20) NOT NULL,

     start_time TIME NOT NULL,
     end_time TIME NOT NULL,

     break_start TIME,
     break_end TIME,

     created_at TIMESTAMP,

     CONSTRAINT fk_availability_doctor
        FOREIGN KEY (doctor_id)
        REFERENCES doctors(id)
);