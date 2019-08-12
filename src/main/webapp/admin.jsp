<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.3.1/css/bootstrap.min.css">
    <title>Консоль администратора</title>
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
<div class="row justify-content-md-center">
    <div class="col-md-auto">
        <h1>Администрирование</h1>
    </div>
</div>
<br>
<br>
<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file"></span>
                            Заказы
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/products">
                            <span data-feather="shopping-cart"></span>
                            Товары
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="users"></span>
                            Пользователи
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

        </main>
    </div>
</div>
<%--<div class="container">--%>
    <%--<div class="row justify-content-md-center">--%>
        <%--<div class="col-md-auto">--%>
            <%--<h1>Консоль администратора</h1>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<c:if test="${not empty sessionScope.result}">--%>
        <%--<c:set var="result" value="${sessionScope.result}"/>--%>
        <%--<c:out value="${result}"/>--%>
        <%--<c:remove var="result" scope="session" />--%>
    <%--</c:if>--%>

    <%--<c:choose>--%>
        <%--<c:when test="${not empty sessionScope.result}">--%>
            <%--<c:set var="result" value="${sessionScope.result}"/>--%>
        <%--</c:when>--%>

        <%--<c:otherwise>--%>
            <%--<c:set var="result" value=""/>--%>
        <%--</c:otherwise>--%>
    <%--</c:choose>--%>

    <%--<c:out value="${result}"/>--%>
    <%--<c:set var="result" value="${sessionScope.result}"/>--%>


    <%--<div class="col-6">--%>
        <%--<form class="col-6" action="addproduct.jsp" method="post">--%>

            <%--<h3>Добавить новый товар</h3>--%>
            <%--<button type="submit" class="btn btn-primary">Создать</button>--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</div>--%>

<script type="text/javascript" src="libs/jquery-3.4.1/jquery-3.4.1.slim.min.js"></script>
<script type="text/javascript" src="libs/propper-1.14.7/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
</body>
</html>
