<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details d'un patient</title>
    <%@include file="../imports/bootstrapImport.html"%>
</head>
<body>
<main class="container p-3 text-bg-dark rounded">
    <h2>Détails d'un patient</h2>
    <hr>
    <img src="${image}">
    <form class="text-bg-dark rounded p-3" action="" method="post">
        <div class="input-group mb-3">
            <input class="form-control" type="text" aria-label="name" value="${patient.getName()}" id="name" name="name">
        </div>
        <div class="input-group mb-3">
            <input class="form-control" type="text" aria-label="phoneNumber" value="${patient.getPhoneNumber()}" id="phoneNumber" name="phoneNumber">
        </div>
        <h3>Ajouter une consultation</h3>
        <a href="${pageContext.request.contextPath}/hospital/patient/consultation/ajout?id=${patient.getId_patient()}">Valider</a>
        <h3>Liste des consultations</h3>
        <c:if test="${patient.getConsultations() != null}">
            <c:forEach var="c" items="${patient.getConsultations()}">
                <p>ref : ${c.getId_consultation()}, Date : ${c.getDateConsultation()},  <a href="${pageContext.request.contextPath}/hospital/patient/consultation/detail?id=${c.getId_consultation()}">Detail de la consultation</a></p>
            </c:forEach>
        </c:if>
    </form>
</main>
</body>
</html>
