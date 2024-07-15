package com.example.exo5.controllers;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.example.exo5.entities.Dog;
import com.example.exo5.repositories.DogRepository;
import com.example.exo5.services.DogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "dogServlet", value = "/dog/*")
public class DogServlet extends HttpServlet {
    private DogService dogService;

    @Override
    public void init() {
        dogService = new DogService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pathInfo = (request.getPathInfo() != null && !request.getPathInfo().isEmpty()) ? request.getPathInfo() : "";
        UUID id;

        switch (pathInfo) {
            case "/detail":
                id = UUID.fromString(request.getParameter("id"));
                request.setAttribute("dog", dogService.getDogById(id));
                getServletContext().getRequestDispatcher("/WEB-INF/pages/detailDog.jsp").forward(request, response);
                break;
            case "/add":
                getServletContext().getRequestDispatcher("/WEB-INF/pages/addDog.jsp").forward(request, response);
                break;
            case "/delete":
                id = UUID.fromString(request.getParameter("id"));
                dogService.deleteDog(id);
            default:
                request.setAttribute("dogs", dogService.getAllDogs());
                getServletContext().getRequestDispatcher("/WEB-INF/pages/allDog.jsp").forward(request, response);
                break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String breed = request.getParameter("breed");
        String birthDateParameter = request.getParameter("birthDate");
        LocalDate birthDate = birthDateParameter.isBlank() || birthDateParameter.isEmpty() ? null : LocalDate.parse(birthDateParameter);

        if(!request.getParameter("id").equals("null")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            dogService.updateDog(id, name, breed, birthDate);
        }
        else
            dogService.saveDog(name, breed, birthDate);

        doGet(request, response);
    }

}