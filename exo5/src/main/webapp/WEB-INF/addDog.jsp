<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/07/2024
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'un chien</title>
    <%@include file="bootstrapImport.html"%>
</head>
<body>
<main class="container">
    <h2>Ajouter un chien</h2>
    <form class="text-bg-dark rounded p-3" action="${pageContext.request.contextPath}/dog" method="post">
        <div class="input-group mb-3">
            <input class="form-control" type="text" aria-label="name" placeholder="Name" id="name" name="name">
        </div>
        <div class="input-group mb-3">
            <input class="form-control" type="text" aria-label="breed" placeholder="Breed" id="breed" name="breed">
        </div>
        <div class="input-group mb-3">
            <input class="form-control" type="date" aria-label="birthdate" placeholder="Birthdate" id="birthdate" name="birthDate" required>
        </div>
        <button class="btn btn-outline-light">Add a dog</button>
    </form>
</main>
</body>
</html>
