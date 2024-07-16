<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'une consultation</title>
    <%@include file="../imports/bootstrapImport.html"%>
</head>
<body>
    <main class="container p-3 text-bg-dark rounded">
        <h2>Patient : <a href="${pageContext.request.contextPath}/hospital/patient/detail?id=${patient.getId_patient()}">${patient.getName()}</a>
        , consultation ref  ${consultation.getId_consultation()}: , Date : ${consultation.getDateConsultation()}</h2>
        <hr>
        <form class="text-bg-dark rounded p-3" action="${pageContext.request.contextPath}/ajout/consultation?id=${consultation.getId_consultation()}" method="post">
            <div class="input-group mb-3">
                <textarea class="form-control" placeholder="${consultation.getCareSheet()}" aria-label="caresheet" id="caresheet" name="caresheet" <c:if test="${!consultation.getCareSheet().isBlank()}">readonly</c:if>></textarea>
                <button class="btn btn-outline-light"><i class="bi bi-plus-square"></i> Valider</button>
            </div>

            <div class="input-group mb-3">
                <textarea class="form-control" placeholder="${consultation.getPrescription()}" aria-label="prescription" id="prescription" name="prescription" <c:if test="${!consultation.getPrescription().isBlank()}">readonly</c:if>></textarea>
                <button class="btn btn-outline-light"><i class="bi bi-plus-square"></i> Valider</button>
            </div>
        </form>
    </main>
</body>
</html>
