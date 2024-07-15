package com.example.exo6.controllers;

import com.example.exo6.services.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@WebServlet(name = "dogServlet", value = "/dog/*")
public class PatientServlet extends HttpServlet {
    private PatientService dogService;

    @Override
    public void init() {
        dogService = new PatientService();
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