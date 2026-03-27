CREATE TABLE doctors (
     id UUID PRIMARY KEY,

     clinic_id UUID NOT NULL,

     name VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     phone VARCHAR(20) NOT NULL,
     specialization VARCHAR(255) NOT NULL,

     active BOOLEAN DEFAULT TRUE,

     created_at TIMESTAMP,
     updated_at TIMESTAMP,

     CONSTRAINT fk_doctor_clinic
        FOREIGN KEY (clinic_id)
        REFERENCES clinics(id)
);