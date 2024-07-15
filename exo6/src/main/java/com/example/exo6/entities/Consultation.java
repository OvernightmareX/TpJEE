package com.example.exo6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_consultation;
    private LocalDate dateConsultation;
    private String nameDoctor;
    private String careSheet;
    private String prescription;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;
}
