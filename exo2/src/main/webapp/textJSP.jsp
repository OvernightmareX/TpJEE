<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 10/07/2024
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="WEB-INF/bootstrapLib.html" %>
    <%@include file="WEB-INF/styles.html" %>
</head>
<body>
    <div class="container">
        <div class="col-9 p-3 offset-2 text-bg-dark rounded-3">
            <h1>Ceci est la page JSP avec bootstrap</h1>
        </div>
    </div>
    <%@include file="WEB-INF/bootstrapScript.html" %>
</body>
</html>