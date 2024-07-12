<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'un chien</title>
    <%@include file="../imports/bootstrapImport.html"%>
</head>
<body>
    <main class="container p-3 text-bg-dark rounded">
        <h2>Ajouter un chien</h2>
        <hr>
        <form class="text-bg-dark rounded p-3" action="${pageContext.request.contextPath}/dog" method="post">
            <div class="input-group mb-3">
                <input class="form-control" type="text" aria-label="name" placeholder="Nom" id="name" name="name" required>
            </div>
            <div class="input-group mb-3">
                <input class="form-control" type="text" aria-label="breed" placeholder="Race" id="breed" name="breed" required>
            </div>
            <div class="input-group mb-3">
                <input class="form-control" type="date" aria-label="birthdate" placeholder="Date de naissance" id="birthdate" name="birthDate" required>
            </div>
            <hr>
            <button class="btn btn-outline-light">Ajouter</button>
        </form>
    </main>
</body>
</html>