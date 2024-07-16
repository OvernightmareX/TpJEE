package com.example.exo6.services;

import com.example.exo6.entities.Consultation;
import com.example.exo6.repositories.ConsultationRepository;

public class ConsultationService {
    ConsultationRepository consultationRepository;

    public ConsultationService() {
        consultationRepository = new ConsultationRepository();
    }

    public Consultation getConsultationById(int id) {
        return consultationRepository.findById(Consultation.class, id);
    }

    public void updateConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
    }
}
