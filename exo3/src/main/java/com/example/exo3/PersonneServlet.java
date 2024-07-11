package com.example.exo3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "personneServlet", value = "/personnes")
public class PersonneServlet extends HttpServlet {
    private List<Personne> personnes;

    public void init() {
        personnes = new ArrayList<>();
        personnes.add(new Personne("Delory", "Christophe", 25));
        personnes.add(new Personne("Walle", "Loick", 29));
        personnes.add(new Personne("Jenaipas", "Dinspi", 404));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("personnes", personnes);
        getServletContext().getRequestDispatcher("/ma-liste.jsp").forward(request, response);
    }

    public void destroy() {
    }
}