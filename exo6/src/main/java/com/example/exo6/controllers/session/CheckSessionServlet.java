package com.example.exo6.controllers.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet(name = "checkSessionServlet",value = "/have-session")
public class CheckSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        HttpSession session = req.getSession();

        boolean logged = (session.getAttribute("isLogged")!= null) ? (boolean) session.getAttribute("isLogged") : false;

        if(!logged){
            out.println("<h1> Pas Connecté </h1>");
        }else {
            out.println("<h1> Connecté </h1>");
        }
        long creationTime = session.getCreationTime();
        long lastAccessedTime = session.getLastAccessedTime();
        int maxInactiveInterval = session.getMaxInactiveInterval();

        // Calclule la durée de la session
        long sessionDuration = ((System.currentTimeMillis()) - creationTime) / 1000; // secondes

        // Calcul heure expiration de la session
        long expirationTime = lastAccessedTime + (maxInactiveInterval*1000);
        Date expirationDate = new Date(expirationTime);

        // retirer un attribut de la session
        //session.removeAttribute("isLogged");

        out.println("<p>Informations session :</p>");
        out.println("<p> Session Id : "+session.getId()+"</p>");
        out.println("<p> Date de creation "+new Date(creationTime)+"</p>");
        out.println("<p> Dernier Acces "+new Date(lastAccessedTime)+"</p>");
        out.println("<p> duree de Session "+sessionDuration+"</p>");
        out.println("<p> Temps max inactivite  "+maxInactiveInterval+"</p>");
        out.println("<p> Session expire dans   "+expirationDate+"</p>");


        out.println("</body></html>");
    }
}
