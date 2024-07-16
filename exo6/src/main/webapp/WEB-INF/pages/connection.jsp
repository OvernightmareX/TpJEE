<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connection</title>
    <%@include file="../imports/bootstrapImport.html"%>
</head>
<body>
<main class="container p-3 text-bg-dark rounded">
    <h2>Se connecter</h2>
    <hr>
    <form class="text-bg-dark rounded p-3" action="${pageContext.request.contextPath}/hospital/patient/list" method="post">
        <div class="input-group mb-3">
            <label for="name">Login</label>
            <input class="form-control" type="text" id="name" name="name" required>
        </div>
        <div class="input-group mb-3">
            <label for="password">Password</label>
            <input class="form-control" type="password" id="password" name="password" required>
        </div>
        <hr>
        <button class="btn btn-outline-light">Valider</button>
        <a class="btn btn-outline-light" href="${pageContext.request.contextPath}/hospital/lobby"><i class="bi bi-arrow-counterclockwise"></i> Retour</a>
    </form>
</main>
</body>
</html>
