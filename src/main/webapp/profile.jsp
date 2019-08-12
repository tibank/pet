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
            <h1>Профиль пользователя</h1>
        </div>
    </div>
    <c:if test="${not empty sessionScope.user}">
        <c:set var="user" value="${sessionScope.user}"/>
        <c:set var="sex" value="${sessionScope.user.getSex()}"/>
        <div class="row">
            <form class="col-6" action="/profile" method="post">
                <div class="form-group">
                    <p class="text-primary font-weight-bold">${user.getEmail()}</p>
                    <%--<label class="text-primary font-weight-bold"--%>
                           <%--for="registrationEmail">${user.getEmail()}</label>--%>
                    <input hidden name="email" type="text" class="form-control" id="registrationEmail"
                           value="${user.getEmail()}">
                </div>

                <div class="form-group">
                    <label for="registrationFirstName">Имя</label>
                    <input name="firstname" type="text" class="form-control" id="registrationFirstName"
                           value="${user.getFirstName()}">
                </div>
                <div class="form-group">
                    <label for="registrationLastName">Фамилия</label>
                    <input name="lastname" type="text" class="form-control" id="registrationLastName"
                           value="${user.getLastName()}">
                </div>
                <div class="form-group">
                    <label for="registrationPassword">Пароль</label>
                    <input name="password" type="password" class="form-control" id="registrationPassword">
                </div>
                <div class="form-group">
                    <label for="sex1">Пол</label>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="sex" id="sex1" value="male"
                            <c:if test="${sex.toString() eq 'male'}">
                                   <c:out value="checked" />
                            </c:if>
                            >Male
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="sex" id="sex2" value="female"
                            <c:if test="${sex.toString() eq 'female'}">
                                <c:out value="checked" />
                            </c:if>
                            >Female
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="registrationBirthDay">Дата рождения</label>
                    <input name="birthday" type="date" class="form-control" id="registrationBirthDay"
                           value="${user.getBirthDay()}">
                </div>
                <button type="submit" class="btn btn-primary">Обновить</button>

            </form>
        </div>

    </c:if>
</div>

<script type="text/javascript" src="libs/jquery-3.4.1/jquery-3.4.1.slim.min.js"></script>
<script type="text/javascript" src="libs/propper-1.14.7/popper.min.js"></script>
<script type="text/javascript" src="libs/bootstrap-4.3.1/js/bootstrap.min.js"></script>

</body>
</html>

