package com.example.exo6.controllers.upload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;


@WebServlet("/deleteFile")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("delete.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        String uploadPath = getServletContext().getRealPath("/")+"image";

        File file = new File(uploadPath,fileName);

        // Verifier si le fichier existe et le supprimmer
        if(file.exists() && file.isFile()){
            if(file.delete()){
                resp.getWriter().write("Fichier delete !!!!");
            }else {
                resp.getWriter().write("Fichier pas delete !!!!");
            }
        }else {
            resp.getWriter().write("Fichier pas exist !!!!");
        }
    }
}
