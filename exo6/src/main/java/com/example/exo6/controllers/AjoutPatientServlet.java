package com.example.exo6.controllers;

import com.example.exo6.services.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;


@WebServlet(name = "patient",value = "/ajout/patient")
@MultipartConfig(maxFileSize = 1024*1024*10) // Limite de 10 MB (10 mégaoctets) pour chaque fichier
public class AjoutPatientServlet extends HttpServlet {
    private PatientService patientService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phoneNumber");
        Part image = req.getPart("image");

        String uploadPath = getServletContext().getRealPath("/")+"image";
        // Utilise pour manipuler les répertoires et les fichiers sur le systeme du serveur
        File file = new File(uploadPath);
        if (!file.exists()){
            file.mkdir();
        }

        String fileName = image.getSubmittedFileName();
        image.write(uploadPath+File.separator+fileName);

        patientService.savePatient(name, phone, fileName);

        resp.sendRedirect(getServletContext().getContextPath()+"/hospital/patient/list");
    }
}
