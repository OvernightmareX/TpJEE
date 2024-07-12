package com.example.exo5.services;

import com.example.exo5.entities.Dog;
import com.example.exo5.repositories.DogRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class DogService {
    DogRepository dogRepository;

    public DogService() {
        dogRepository = new DogRepository();
    }

    public void saveDog(String name, String breed, LocalDate birthDate) {
        dogRepository.save(Dog.builder()
                .name(name)
                .breed(breed)
                .birthDate(birthDate)
                .build());
    }

    public List<Dog> getAllDogs(){
        return dogRepository.findAll(Dog.class);
    }

    public Dog getDogById(UUID id) {
        return dogRepository.findById(Dog.class, id);
    }
}
