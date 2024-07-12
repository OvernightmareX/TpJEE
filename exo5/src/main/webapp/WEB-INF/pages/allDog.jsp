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
            <c:choose>
                <c:when test="${dogs.size() == 0}">
                    <hr>
                    <h2>Vous n'avez aucun chien dans votre liste.</h2>
                    <hr>
                </c:when>
                <c:otherwise>
                    <table class="table table-dark table-striped border border-secondary">
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
                                <td class="align-middle">${d.getName()}</td>
                                <td class="align-middle">${d.getBreed()}</td>
                                <td class="align-middle">${d.getBirthDate()}</td>
                                <td class="align-middle"><a href="dog/detail?id=${d.getId()}" class="btn btn-outline-primary"><i class="bi bi-eye"></i> Détails</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
            <a href="dog/add" class="btn btn-outline-secondary"><i class="bi bi-plus-square"></i> Ajouter un chien</a>
        </main>
    </body>
</html>