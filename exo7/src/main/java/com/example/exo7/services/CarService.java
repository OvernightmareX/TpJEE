package com.example.exo7.services;

import com.example.exo7.entities.Car;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CarService {
    List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
        cars.add(Car.builder().id(1).brand("Test").creationDate(1992).color("rouge").build());
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int id) {
        return cars.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public Car save(Car car){
        Car carToSave = Car.builder()
                .id(cars.size()+1)
                .brand(car.getBrand())
                .creationDate(car.getCreationDate())
                .color(car.getColor())
                .build();
        cars.add(carToSave);
        return carToSave;
    }

    public Car update(Car car){

        Car carToUpdate = getCar(car.getId());
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setCreationDate(car.getCreationDate());
        carToUpdate.setColor(car.getColor());
        return carToUpdate;
    }

    public boolean deleteCar(int id){
        cars.removeIf(car -> car.getId() == id);
        return true;
    }
}
