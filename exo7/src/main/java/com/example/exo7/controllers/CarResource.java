package com.example.exo7.controllers;

import com.example.exo7.entities.Car;
import com.example.exo7.services.CarService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

    private final CarService carService;

    @Inject
    public CarResource(CarService carService){
        this.carService = carService;
    }

    @GET
    public List<Car> getAllCars() {
        return carService.getCars();
    }

    @GET
    @Path("{id}")
    public Car getCar(@PathParam("id") UUID id){
        return carService.getCar(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Car saveCar(Car car){
        return carService.save(car);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Car updateCar(@QueryParam("id") UUID id, Car car){
        return carService.update(id, car);
    }

    @DELETE
    @Path("{id}")
    public boolean deleteCar(@PathParam("id") UUID id){
        return carService.deleteCar(id);
    }
}