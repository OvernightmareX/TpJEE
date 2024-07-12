<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Affichage des chiens</title>
        <c:import url="bootstrapImport.html"/>
    </head>
    <body>
        <main class="container">
            <h1>Ma liste de chien : </h1>
            <c:when test="${dogs.size() == 0}">
                <h2>Vous n'avez aucun chien dans votre liste.</h2>
            </c:when>
            <c:otherwise>
                <table class="table table-dark table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Breed</th>
                        <th scope="col">Birth date</th>
                        <th scope="col">Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="d" items="${dogs}">
                        <tr>
                            <td>${d.getName()}</td>
                            <td>${d.getBreed()}</td>
                            <td>${d.getBirthDate()}</td>
                            <td><a href="dog/detail/" class="btn btn-outline-primary">Details</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
            <a href="dog/add" class="btn btn-outline-dark">Add a dog</a>
        </main>
    </body>
</html>