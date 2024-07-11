package com.example.exo4.models;

import com.example.exo4.utils.FoodType;

import java.time.LocalDate;

public class Cat {
    private String name;
    private String race;
    private FoodType favoriteFood;
    private LocalDate birthDate;

    public Cat(String name, String race, FoodType favoriteFood, LocalDate birthDate) {
        this.name = name;
        this.race = race;
        this.favoriteFood = favoriteFood;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public FoodType getFavoriteFood() {
        return favoriteFood;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
