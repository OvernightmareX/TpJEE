package com.example.exo7.services;

import com.example.exo7.entities.Car;
import com.example.exo7.repositories.CarRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CarService {
    private CarRepository carRepository = new CarRepository();

    public CarService() {
        carRepository.save(Car.builder().brand("Test").creationDate(1992).color("rouge").build());
    }

    public List<Car> getCars() {
        return carRepository.findAll(Car.class);
    }

    public Car getCar(UUID id) {
        return carRepository.findByUUID(Car.class, id);
    }

    public Car save(Car car){
        Car carToSave = Car.builder()
                .brand(car.getBrand())
                .creationDate(car.getCreationDate())
                .color(car.getColor())
                .build();

        carRepository.save(carToSave);
        return carToSave;
    }

    public Car update(UUID id, Car car){
        Car carToUpdate = getCar(id);
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setCreationDate(car.getCreationDate());
        carToUpdate.setColor(car.getColor());
        carRepository.save(carToUpdate);
        return carToUpdate;
    }

    public boolean deleteCar(UUID id){
        Car carToDelete = getCar(id);
        carRepository.delete(carToDelete);
        return true;
    }
}
