<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.3.1/css/bootstrap.min.css">
    <title>Карточка товара</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-auto">
            <h1>Карточка товара</h1>
        </div>
    </div>
    <div class="col-8">
        <form class="col-md-12" action="/addproduct" method="post">

            <div class="form-group">
                <label class="text-info font-weight-bold" for="productName">Наименование</label>
                <input name="name" type="text" class="form-control" id="productName" placeholder="Наименование">
            </div>

            <div class="col-md-6">
                <div class="form-group">

                    <label class="text-info font-weight-bold" for="productWeight">Вес</label>
                    <input name="weight" type="number" step="any" class="form-control" id="productWeight"
                           placeholder="Вес">
                </div>
                <div class="form-group">
                    <label class="text-info font-weight-bold" for="productVolume">Объем</label>
                    <input name="volume" type="number" step="any" class="form-control" id="productVolume"
                           placeholder="Объем">
                </div>
                <div class="form-group">
                    <label class="text-info font-weight-bold" for="productPrice">Цена</label>
                    <input name="price" type="number" step="5.00" class="form-control" id="productPrice"
                           placeholder="Цена">
                </div>
            </div>

            <div class="form-group">
                <label class="text-info font-weight-bold" for="sel1">Выберите категорию:</label>
                <select name="categoryId" class="form-control" id="sel1">
                    <c:forEach items="${sessionScope.categories}" var="category">
                        <option value = "${category.getId()}">${category.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="text-info font-weight-bold" for="productDescription">Описание</label>
                <textarea class="form-control" rows="5" id="productDescription" name="description"></textarea>
            </div>

            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form>
    </div>
</div>
</body>
</html>
