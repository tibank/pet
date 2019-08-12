<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="libs/awesome-5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Регистрация в системе</title>
</head>

<body>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-auto">
            <h1>Регистрация</h1>
        </div>
    </div>
    <c:choose>
        <c:when test="${empty sessionScope.user}">
            <div class="row">
                <div class="col-6">
                    <h3>Логин</h3>
                </div>
                <div class="col-6">
                    <h3>Регистрация</h3>
                </div>
            </div>
            <div class="row">
                <form class="col-6" action="/login" method="post">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email</label>
                        <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Введите email">
                        <small id="emailHelp" class="form-text text-muted">Мы никому не будем передавать Ваш email</small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Пароль</label>
                        <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Пароль">
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
                <form class="col-6" action="/register" method="post">
                    <div class="form-group">
                        <label for="registrationEmail">Email</label>
                        <input name="email" type="email" class="form-control" id="registrationEmail" aria-describedby="emailHelp" placeholder="Введите email">
                        <small id="registrationEmailHelp" class="form-text text-muted">Введите валидный email</small>
                    </div>
                    <div class="form-group">
                        <label for="registrationPassword">Пароль</label>
                        <input name="password" type="password" class="form-control" id="registrationPassword" placeholder="Пароль">
                    </div>
                    <div class="form-group">
                        <label for="registrationFirstName">Имя</label>
                        <input name="firstname" type="text" class="form-control" id="registrationFirstName" placeholder="Имя">
                    </div>
                    <div class="form-group">
                        <label for="registrationLastName">Фамилия</label>
                        <input name="lastname" type="text" class="form-control" id="registrationLastName" placeholder="Фамилия">
                    </div>
                    <div class="form-group">
                        <label for="sex1">Пол</label>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="sex" id="sex1" value="male" checked>Male
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="sex" id="sex2" value="female">Female
                        </label>
                    </div>
                    </div>
                    <div class="form-group">
                        <label for="registrationBirthDay">Дата рождения</label>
                        <input name="birthday" type="date" class="form-control" id="registrationBirthDay" placeholder="Дата рождения">
                    </div>
                    <button type="submit" class="btn btn-primary">Регистрация</button>
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <a href="/profile.jsp" class="btn btn-info" role="button">Профиль</a>
            <%--<button type="button" class="btn btn-info">Button</button>--%>
            <%--<form class="col-6" action="/profile.jsp" method="get">--%>
                <%--<button type="submit" class="btn btn-primary">Посмотреть профиль пользователя</button>--%>
            <%--</form>--%>
        </c:otherwise>
    </c:choose>
</div>

<script type="text/javascript" src="libs/jquery-3.4.1/jquery-3.4.1.slim.min.js"></script>
<script type="text/javascript" src="libs/propper-1.14.7/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
