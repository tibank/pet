<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="libs/awesome-5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Главная страница</title>

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-md flex-md-nowrap p-1 navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">Spring 2019</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <a class="nav-link text-white" href="/profile.jsp">Hello,
                            <c:out value="${sessionScope.user.getFirstName()}!"/>
                        </a>
                    </c:when>

                    <c:otherwise>
                        <a class="nav-link  text-white" href="login.jsp">Hello, Гость! </a>
                    </c:otherwise>
                </c:choose>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Меню</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">

                    <c:choose>
                        <c:when test="${empty sessionScope.user}">
                            <a class="dropdown-item" href="/login.jsp">Login</a>
                        </c:when>
                        <c:otherwise>
                            <a class="dropdown-item" href="/profile.jsp">Profile </a>
                            <c:if test="${sessionScope.user.isAdmin()}">
                                <a class="dropdown-item" href="/admin">Admin</a>
                            </c:if>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/logout">Logout</a>
                        </c:otherwise>
                    </c:choose>


                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <form class="form-inline my-2 my-lg-0" action="/cart.jsp" method="get">
            <button class="btn btn-info my-2 my-sm-0 cart" type="submit"> Корзина, <span>
                <c:choose>
                    <c:when test="${cart != null}">
                        <c:out value="${cart.getQuantity()}"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="0"/>
                    </c:otherwise>
                </c:choose>
                </span>
            </button>
        </form>
    </div>
</nav>

<br>
<br>
<div class="container-fluid">
    <div class="row">
        <nav class="col-md-3 col-lg-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <form class="col-6" action="/filter" method="post">
                    <ul class="nav flex-column">

                        <c:forEach items="${sessionScope.categories}" var="category">
                            <li class="nav-item">
                                <div class="form-check">
                                    <label class="form-check-label" for="check${category.getId()}">
                                        <input type="checkbox" class="form-check-input" id="check${category.getId()}"
                                               name="option${category.getId()}"
                                               value="${category.getId()}">${category.getName()}
                                    </label>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>

                    <div class="row">
                        <label for="minPrice">Мин.цена</label>
                        <input name="minprice" type="number" step="10.00" class="form-control" id="minPrice" value="0">
                        <%--<input type="range" class="custom-range" id="minPrice" name="minprice"--%>
                        <%--oninput="minPrice()" min="0" max="1000" step="10" value="100">--%>
                    </div>
                    <div class="row">
                        <label for="maxPrice">Макс.цена</label>
                        <input name="maxprice" type="number" step="10.00" class="form-control" id="maxPrice" value="0">
                    </div>
                    <div></div>

                    <div class="row">
                        <%--<form class="col-6" action="/filter" method="post">--%>
                        <button type="submit" class="btn btn-primary">Фильтр</button>
                        <%--</form>--%>
                    </div>
                </form>

            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <table class="table table-hover col-md-12">
                    <thead>
                    <tr>
                        <td class="w-25"></td>
                        <td class="w-25"></td>
                        <td class="w-25"></td>
                        <td class="w-25"></td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <c:forEach items="${sessionScope.products}" var="product" varStatus="сounter">
                        <td>
                            <p class="font-weight-bold text-info">${product.getName()}</p>

                            <div class="clearfix">
                                <span class="font-weight-bold text-info float-left">Цена:</span>
                                <span class="font-weight-bold text-body float-right">${product.getPrice()}</span>
                            </div>
                                <%--<fmt:formatNumber type = "number" pattern = "####0.0#" value = "${product.getPrice()}" scope="session" />--%>
                            <div class="clearfix">
                                <div class="font-weight-bold text-info float-left">Объем:   </div>
                                <div class="font-weight-bold text-body float-right">${product.getVolume()} </div>
                            </div>

                            <div class="clearfix">
                                <div class="font-weight-bold text-info float-left">Вес:   </div>
                                <div class="font-weight-bold text-body float-right">${product.getWeight()} </div>
                            </div>

                            <div class="clearfix">
                                <div class="font-weight-bold text-info float-left">Описание:   </div>
                                <div class="font-weight-light text-secondary"> ${product.getDescription()} </div>
                            </div>

                            <br>

                            <div class="row">
                                <form class="col-6" action="/buy?productId=${product.getId()}" method="post">
                                    <button type="submit" class="btn btn-primary">Купить</button>
                                </form>
                            </div>
                        </td>
                        <c:if test="${сounter.count%4 == 0}">
                    </tr>
                    <tr>
                        </c:if>
                        </c:forEach>
                    </tr>
                    </tbody>
                </table>

            </div>

        </main>
    </div>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-bottom">
    <a class="navbar-brand" href="#">Spring 2019</a>
</nav>

<script type="text/javascript" src="libs/jquery-3.4.1/jquery-3.4.1.slim.min.js"></script>
<script type="text/javascript" src="libs/propper-1.14.7/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.3.1/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function () {
        $('.cart').tooltip({title: "${cart.getTotalFormat()}", animation: false});
    });
</script>

<script>
    function minPrice() {
        var range = document.getElementById('minRange'); //rng - это ползунок
        var price = document.getElementById('minPrice'); // i1 - input
        price.value = range.value;
        // $(document).ready(function () {
        //     document.getElementById("minRange").value = document.getElementById("minPrice").value;
        // });
    }
</script>

</body>
</html>
