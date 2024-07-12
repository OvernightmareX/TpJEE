<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Affichage des chiens</title>
        <c:import url="../imports/bootstrapImport.html"/>
    </head>
    <body>
        <main class="container p-3 text-bg-dark rounded">
            <h1>Ma liste de chien : </h1>
            <hr>
            <c:choose>
                <c:when test="${dogs.size() == 0}">
                    <h2>Vous n'avez aucun chien dans votre liste.</h2>
                </c:when>
                <c:otherwise>
                    <table class="table table-dark table-striped">
                        <thead>
                        <tr>
                            <th scope="col">Nom</th>
                            <th scope="col">Race</th>
                            <th scope="col">Date de naissance</th>
                            <th scope="col">Détails</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="d" items="${dogs}">
                            <tr>
                                <td>${d.getName()}</td>
                                <td>${d.getBreed()}</td>
                                <td>${d.getBirthDate()}</td>
                                <td><a href="dog/detail/${d.getId()}" class="btn btn-outline-primary">Détails</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
            <hr>
            <a href="dog/add" class="btn btn-outline-light">Ajouter un chien</a>
        </main>
    </body>
</html>