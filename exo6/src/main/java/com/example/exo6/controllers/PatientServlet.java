package com.example.exo6.controllers;

import com.example.exo6.entities.Consultation;
import com.example.exo6.entities.Patient;
import com.example.exo6.services.ConsultationService;
import com.example.exo6.services.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "patientServlet", value = "/hospital/*")
public class PatientServlet extends HttpServlet {
    private PatientService patientService;
    private ConsultationService consultationService;

    @Override
    public void init() {
        patientService = new PatientService();
        consultationService = new ConsultationService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pathInfo = (request.getPathInfo() != null && !request.getPathInfo().isEmpty()) ? request.getPathInfo() : "";
        HttpSession session = request.getSession();
        boolean logged = session.getAttribute("isLogged") != null && (boolean) session.getAttribute("isLogged");
        Patient patient;
        Consultation consultation;

        System.out.println(logged);
        if(logged){
            request.setAttribute("logged", true);
        }

        switch (pathInfo) {
            case "/lobby":
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/patient/list":
                request.setAttribute("patients", patientService.getAllPatients());
                getServletContext().getRequestDispatcher("/WEB-INF/pages/patientMenu.jsp").forward(request, response);
                break;
            case "/connection":
                getServletContext().getRequestDispatcher("/WEB-INF/pages/connection.jsp").forward(request, response);
                break;
            case "/patient/detail":
                patient = patientService.getPatientById(UUID.fromString(request.getParameter("id")));
                String image = request.getContextPath()+"/image/"+patient.getImage();
                request.setAttribute("patient", patient);
                request.setAttribute("image", image);
                getServletContext().getRequestDispatcher("/WEB-INF/pages/detailPatient.jsp").forward(request, response);
                break;
            case "/patient/consultation/ajout":
                patient = patientService.getPatientById(UUID.fromString(request.getParameter("id")));
                consultation = patientService.addConsultation(patient);
                request.setAttribute("consultation", consultation);
                request.setAttribute("patient", patient);
                getServletContext().getRequestDispatcher("/WEB-INF/pages/consultation.jsp").forward(request, response);
                break;
            case "/patient/consultation/detail":
                consultation = consultationService.getConsultationById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("consultation", consultation);
                request.setAttribute("patient", consultation.getPatient());
                getServletContext().getRequestDispatcher("/WEB-INF/pages/consultation.jsp").forward(request, response);
                break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if(name.equals("House") && password.equals("Wilson")){
            HttpSession session = request.getSession();
            session.setAttribute("isLogged",true);
        }
        doGet(request, response);
    }

}