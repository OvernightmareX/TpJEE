<%@ page import="com.example.exo3.Personne" %>
<jsp:useBean id="personnes" type="java.util.ArrayList<com.example.exo3.Personne>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="WEB-INF/bootstrapImport.html"%>
</head>
<body>
    <div class="container">
        <h1>Ma liste de personnes : </h1>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Nom</th>
                <th scope="col">Prenom</th>
                <th scope="col">Age</th>
            </tr>
            </thead>
            <tbody>
                <% for(Personne p : personnes) {%>
                <tr>
                    <td><%= p.getPrenom() %></td>
                    <td><%= p.getNom() %></td>
                    <td><%= p.getAge() + " ans"%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
</body>
</html>
