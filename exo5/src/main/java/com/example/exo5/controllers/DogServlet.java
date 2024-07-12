package com.example.exo5.controllers;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.exo5.entities.Dog;
import com.example.exo5.repositories.DogRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "dogServlet", value = "/dog/*")
public class DogServlet extends HttpServlet {
    private DogRepository dogRepository;

    @Override
    public void init() {
        dogRepository = new DogRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pathInfo = (request.getPathInfo() != null && !request.getPathInfo().isEmpty()) ? request.getPathInfo() : "";

        if(pathInfo.startsWith("/detail")) {
            UUID id = UUID.fromString(pathInfo.substring(8));
            request.setAttribute("dog", dogRepository.findById(Dog.class, id));
            getServletContext().getRequestDispatcher("/WEB-INF/pages/detailDog.jsp").forward(request, response);
            return;
        }

        if(pathInfo.startsWith("/add")) {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/addDog.jsp").forward(request, response);
            return;
        }

        request.setAttribute("dogs", dogRepository.findAll(Dog.class));
        getServletContext().getRequestDispatcher("/WEB-INF/pages/allDog.jsp").forward(request, response);
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