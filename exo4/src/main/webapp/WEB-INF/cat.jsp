<%@ page import="com.example.exo4.models.Cat" %>
<jsp:useBean id="cats" type="java.util.ArrayList<com.example.exo4.models.Cat>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List des chats</title>
    <%@include file="bootstrapImport.html"%>
</head>
<body>
<div class="container">
    <h1>Ma liste de chat : </h1>

    <% if(cats.isEmpty()) {%>
        <h2>Vous n'avez aucun chat dans votre liste.</h2>
    <%} else{%>
        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Race</th>
                <th scope="col">Favorite Food</th>
                <th scope="col">Birth date</th>
            </tr>
            </thead>
            <tbody>
            <% for(Cat c : cats) {%>
            <tr>
                <td><%= c.getName() %></td>
                <td><%= c.getRace() %></td>
                <td><%= c.getFavoriteFood()%></td>
                <td><%= c.getBirthDate()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    <%}%>
    <hr>
    <h2>Ajouter un chat</h2>
    <form class="text-bg-dark rounded p-3" action="cat-servlet" method="post">
        <div class="input-group mb-3">
            <input class="form-control" type="text" aria-label="name" placeholder="Name" id="name" name="name">
        </div>
        <div class="input-group mb-3">
            <input class="form-control" type="text" aria-label="race" placeholder="Race" id="race" name="race">
        </div>
        <div class="input-group mb-3">
            <select aria-label="food" class="col-12 rounded" id="food" name="food">
                <option value="0" selected>Croquette</option>
                <option value="1">Pate</option>
                <option value="2">Poisson</option>
                <option value="3">Jerry</option>
            </select>
        </div>
        <div class="input-group mb-3">
            <input class="form-control" type="date" aria-label="birthdate" placeholder="Birthdate" id="birthdate" name="birthdate">
        </div>
        <button class="btn btn-outline-light">Add a cat</button>
    </form>
</div>
</body>
</html>
