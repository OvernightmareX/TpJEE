package com.example.exo1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servletBrut", value = "/servlet-brut")
public class ServletBrut extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("Ceci est du texte brut !!");
    }

    public void destroy() {
    }
}