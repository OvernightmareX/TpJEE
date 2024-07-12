package com.example.exo5.services;

import com.example.exo5.entities.Dog;
import com.example.exo5.repositories.DogRepository;

import java.util.List;
import java.util.UUID;

public class DogService {
    DogRepository dogRepository;

    public DogService() {
        dogRepository = new DogRepository();
    }

    public void saveDog(Dog dog) {
        dogRepository.save(dog);
    }

    public List<Dog> getAllDogs(){
        return dogRepository.findAll(Dog.class);
    }

    public Dog getDogById(UUID id) {
        return dogRepository.findById(Dog.class, id);
    }
}
