package com.example.exo6.repositories;

import com.example.exo6.entities.Patient;
import jakarta.persistence.Query;

public class PatientRepository extends BaseRepository<Patient> {

    public Patient findByName(String name) {
        String query = "FROM Patient WHERE name = :name";
        session = sessionFactory.openSession();
        Query typedQuery = session.createQuery(query, Patient.class);
        typedQuery.setParameter("name", name);
        Patient patient = (Patient) typedQuery.getSingleResult();
        session.close();
        return patient;
    }
}
