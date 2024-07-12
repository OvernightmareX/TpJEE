package com.example.exo5.controllers;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.exo5.entities.Dog;
import com.example.exo5.repositories.DogRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "dogServlet", value = {"/dog", "/dog/*"})
public class DogServlet extends HttpServlet {
    private DogRepository dogRepository = new DogRepository();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pathInfo = (request.getPathInfo() != null && !request.getPathInfo().isEmpty()) ? request.getPathInfo() : "";

        System.out.println(pathInfo);
        switch (pathInfo) {
            case "/detail":
                getServletContext().getRequestDispatcher("/WEB-INF/detailDog.jsp").forward(request, response);
                break;
            case "/add":
                getServletContext().getRequestDispatcher("/WEB-INF/addDog.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("dogs", dogRepository.findAll(Dog.class));
                getServletContext().getRequestDispatcher("/WEB-INF/allDog.jsp").forward(request, response);
                break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String breed = request.getParameter("breed");
        String birthDateParameter = request.getParameter("birthDate");
        LocalDate birthDate = birthDateParameter.isBlank() || birthDateParameter.isEmpty() ? null : LocalDate.parse(birthDateParameter);

        dogRepository.save(Dog.builder()
                        .name(name)
                        .breed(breed)
                        .birthDate(birthDate)
                        .build());

        doGet(request, response);
    }

}