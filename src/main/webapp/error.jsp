<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="libs/awesome-5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Страница ошибок</title>
</head>

<body>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-auto">
            <div class="alert alert-danger">
                <strong>Ahtung!!! Error!!!</strong>
            </div>

        </div>
    </div>

    <c:if test="${not empty sessionScope.error}" >
        <p class="text-danger font-weight-bold"><c:out value="${sessionScope.error.getMsgError()}"/></p>

        <c:if test="${sessionScope.error.getClassException().toString() eq 'ValidationException'}" >
            <c:forEach items="${sessionScope.error.getListError()}" var="error">
                <h5>
                    <c:out value="${error}"/>
                </h5>
            </c:forEach>
        </c:if>
        <c:out value="${requestScope.error.getClassException()}"/>
    </c:if>
</div>

<script type="text/javascript" src="libs/jquery-3.4.1/jquery-3.4.1.slim.min.js"></script>
<script type="text/javascript" src="libs/propper-1.14.7/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
