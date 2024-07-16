package com.example.exo6.controllers;

import com.example.exo6.entities.Consultation;
import com.example.exo6.services.ConsultationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "consultation",value = "/ajout/consultation/*")
public class AjoutConsultationServlet extends HttpServlet {
    private ConsultationService consultationService;

    @Override
    public void init() throws ServletException {
        consultationService = new ConsultationService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Consultation consultation = consultationService.getConsultationById(Integer.parseInt(request.getParameter("id")));
        if(consultation.getCareSheet().isBlank())
            consultation.setCareSheet(request.getParameter("caresheet"));
        if(consultation.getPrescription().isBlank())
            consultation.setPrescription(request.getParameter("prescription"));

        consultationService.updateConsultation(consultation);

        response.sendRedirect(getServletContext().getContextPath()+"/hospital/patient/consultation/detail?id="+consultation.getId_consultation());
    }
}
