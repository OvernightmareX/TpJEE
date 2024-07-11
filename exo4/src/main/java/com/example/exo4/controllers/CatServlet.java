package com.example.exo4.controllers;

import com.example.exo4.models.Cat;
import com.example.exo4.utils.FoodType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "catServlet", value = "/cat-servlet")
public class CatServlet extends HttpServlet {
    List<Cat> cats;

    @Override
    public void init() throws ServletException {
        cats = new ArrayList<>();
        //cats.add(new Cat("Tom", "Cartoon", FoodType.JERRY, LocalDate.of(1990, 1, 1)));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cats", cats);
        getServletContext().getRequestDispatcher("/WEB-INF/cat.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String race = request.getParameter("race");
        FoodType food = getFoodType(request);
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthdate"));

        cats.add(new Cat(name, race,food, birthDate));
        request.setAttribute("cats", cats);
        getServletContext().getRequestDispatcher("/WEB-INF/cat.jsp").forward(request, response);
    }

    private static FoodType getFoodType(HttpServletRequest request) {
        return switch (Integer.parseInt(request.getParameter("food"))){
            case 0 -> FoodType.CROQUETTE;
            case 1 -> FoodType.PATE;
            case 2 -> FoodType.POISSON;
            case 3 -> FoodType.JERRY;
            default ->
                    throw new IllegalStateException("Unexpected value: " + Integer.parseInt(request.getParameter("food")));
        };
    }
}
