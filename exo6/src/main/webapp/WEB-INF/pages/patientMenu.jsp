<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Affichage des patients</title>
        <c:import url="../imports/bootstrapImport.html"/>
    </head>
    <body>
        <main class="container p-3 text-bg-dark rounded">
            <hr>
            <h3>Ajouter un patient</h3>
            <c:choose>
                <c:when test="${logged}">
                    <form class="text-bg-dark rounded p-3" action="${pageContext.request.contextPath}/ajout/patient" method="post" enctype="multipart/form-data">
                        <div class="input-group mb-3">
                            <input class="form-control" type="text" aria-label="name" placeholder="Nom" id="name" name="name" required>
                        </div>
                        <div class="input-group mb-3">
                            <input class="form-control" type="text" aria-label="phoneNumber" placeholder="Numéro de téléphone" id="phoneNumber" name="phoneNumber" required>
                        </div>
                        <div class="input-group mb-3">
                            <input class="form-control" type="file" aria-label="image" id="image" name="image" required>
                        </div>
                        <hr>
                        <button class="btn btn-outline-light"><i class="bi bi-plus-square"></i> Ajouter</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/hospital/connection">Se connecter</a>
                </c:otherwise>
            </c:choose>
            <hr>
            <h3>Liste des patients : </h3>
            <c:choose>
                <c:when test="${patients.size() >= 0}">
                    <table class="table table-dark table-striped border border-secondary">
                        <thead>
                        <tr>
                            <th scope="col">Nom</th>
                            <th scope="col">Numéro de téléphone</th>
                            <th scope="col">Detail</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="p" items="${patients}">
                            <tr>
                                <td class="align-middle">${p.getName()}</td>
                                <td class="align-middle">${p.getPhoneNumber()}</td>
                                <td class="align-middle"><a href="${pageContext.request.contextPath}/hospital/patient/detail?id=${p.getId_patient()}" class="btn btn-outline-primary"><i class="bi bi-eye"></i> Détails</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:when>
            </c:choose>
        </main>
    </body>
</html>