<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.3.1/css/bootstrap.min.css">
    <title>Ответ</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="index.jsp">Spring 2019</a>

    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home</a>
        </li>
    </ul>
</nav>
<br>
<br>
<div class="row justify-content-md-center">
    <div class="col-md-auto">
        <h1>Результат операции</h1>
    </div>

    <c:if test="${not empty sessionScope.resultOperation}">
    <div class="alert alert-warning">
        <strong>Warning!</strong> ${sessionScope.resultOperation}}
    </div>
    </c:if>

    <div/>

    <div class="container">
        <div class="row justify-content-md-center">
            <form method="get">
                <input formaction="index.jsp" type="submit" class="btn btn-info" value="Возврат">
            </form>
        </div>
    </div>
</body>
</html>
