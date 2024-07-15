package com.example.exo6.services;

import com.example.exo6.entities.Patient;
import com.example.exo6.repositories.PatientRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PatientService {
    PatientRepository dogRepository;

    public PatientService() {
        dogRepository = new PatientRepository();
    }

    public void saveDog(String name, String breed, LocalDate birthDate) {
        dogRepository.save(Patient.builder()
                        .name(name)
                        .build());
    }

    public void updateDog(UUID id, String name, String breed, LocalDate birthDate) {
        dogRepository.save(new Patient());
    }

    public boolean deleteDog(UUID id) {
        return dogRepository.delete(getDogById(id));
    }

    public List<Patient> getAllDogs(){
        return dogRepository.findAll(Patient.class);
    }

    public Patient getDogById(UUID id) {
        return dogRepository.findById(Patient.class, id);
    }
}
