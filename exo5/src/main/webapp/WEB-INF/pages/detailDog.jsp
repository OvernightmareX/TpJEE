<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details d'un chien</title>
    <%@include file="../imports/bootstrapImport.html"%>
</head>
<body>
<main class="container p-3 text-bg-dark rounded">
    <h2>Détails d'un chien</h2>
    <hr>
    <form class="text-bg-dark rounded p-3" action="${pageContext.request.contextPath}/dog" method="post">
        <div class="input-group mb-3">
            <input class="form-control" type="text" aria-label="name" value="${dog.getName()}" id="name" name="name" readonly>
        </div>
        <div class="input-group mb-3">
            <input class="form-control" type="text" aria-label="breed" value="${dog.getBreed()}" id="breed" name="breed" readonly>
        </div>
        <div class="input-group mb-3">
            <input class="form-control" type="date" aria-label="birthdate" value="${dog.getBirthDate()}" id="birthdate" name="birthDate" readonly>
        </div>
        <hr>
        <a class="btn btn-outline-light" href="${pageContext.request.contextPath}/dog"><i class="bi bi-arrow-counterclockwise"></i> Retour</a>
    </form>
</main>
</body>
</html>
