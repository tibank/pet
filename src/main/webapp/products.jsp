<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.3.1/css/bootstrap.min.css">
    <title>Администрирование товары</title>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="index.jsp">Spring 2019</a>

    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="addproduct.jsp">Добавить товар</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <table class="table table table-hover col-md-12">
        <thead>
        <tr>
            <td class="w-55">Наименование</td>
            <td class="w-15">Цена</td>
            <td class="w-15">Объем</td>
            <td class="w-15">Вес</td>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty sessionScope.user}">
            <c:forEach items="${sessionScope.products}" var="product" varStatus="сounter">
                <tr>
                    <td>
                        <p class="font-weight-bold text-info">${product.getName()}</p>
                    </td>

                    <td>
                        <span class="font-weight-bold text-body text-center">${product.getPrice()}</span>
                    </td>

                    <td>
                        <span class="font-weight-bold text-body text-center">${product.getVolume()}</span>
                    </td>

                    <td>
                        <span class="font-weight-bold text-body text-center">${product.getWeight()}</span>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
</body>
</html>
