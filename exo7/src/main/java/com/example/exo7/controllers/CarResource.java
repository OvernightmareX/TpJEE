package com.example.exo7.controllers;

import com.example.exo7.entities.Car;
import com.example.exo7.services.CarService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Path("/car")
public class CarResource {

    private final CarService carService;

    @Inject
    public CarResource(CarService carService){
        this.carService = carService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars() {
        return carService.getCars();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("id") int id){
        return carService.getCar(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car saveCar(Car car){
        return carService.save(car);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car updateCar(Car car){
        return carService.update(car);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteCar(@PathParam("id") int id){
        return carService.deleteCar(id);
    }
}