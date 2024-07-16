package com.example.exo6.services;

import com.example.exo6.entities.Consultation;
import com.example.exo6.entities.Patient;
import com.example.exo6.repositories.PatientRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PatientService {
    PatientRepository patientRepository;

    public PatientService() {
        patientRepository = new PatientRepository();
    }

    public void savePatient(String name, String phoneNumber, String image) {
        patientRepository.save(Patient.builder()
                        .name(name)
                        .phoneNumber(phoneNumber)
                        .image(image)
                        .build());
    }

    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Consultation addConsultation(Patient patient) {
        Consultation consultation = new Consultation();
        consultation.setPatient(patient);
        consultation.setDateConsultation(LocalDate.now());
        consultation.setNameDoctor("Dr.House");
        consultation.setCareSheet("");
        consultation.setPrescription("");
        patient.getConsultations().add(consultation);
        patientRepository.save(patient);
        return consultation;
    }

    public boolean deletePatient(UUID id) {
        return patientRepository.delete(getPatientById(id));
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll(Patient.class);
    }

    public Patient getPatientById(UUID id) {
        return patientRepository.findById(Patient.class, id);
    }

    public Patient getPatientByName(String name) {
        return patientRepository.findByName(name);
    }
}
