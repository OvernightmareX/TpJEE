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
        <ul class="list-group col-5">
            <% for(Personne p : personnes) {%>
            <li class="list-group-item"><%= p.getPrenom() + " " + p.getNom() + " " + p.getAge() + " ans"%></li>
            <%}%>
        </ul>
    </div>
</body>
</html>
