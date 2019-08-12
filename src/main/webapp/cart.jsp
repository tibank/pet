<%@ page import="com.epam.rd.spring2019.pet.models.TradeUnit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap-4.3.1/css/bootstrap.min.css">
    <title>Заказ</title>
</head>
<body>
<div class="container">
    <h2>Заказ</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Наименование</th>
            <th>Цена</th>
            <th>Количество</th>
            <th>Сумма</th>
            <th>Изменить</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope.cart.getTradeUnitMap()}" var="tradeUnit" varStatus="сounter">
            <c:set var="id" scope="session" value="${tradeUnit.getKey()}" />
            <tr>
                <td>
                    <div class="font-weight-bold text-info">${tradeUnit.getValue().getProduct().getName()}</div>
                </td>
                <td>
                    <div class="font-weight-bold text-body">${tradeUnit.getValue().getPrice()} </div>
                </td>
                <td>
                    <div class="font-weight-bold text-body">${tradeUnit.getValue().getQuantity()} </div>
                </td>
                <td>
                    <div class="font-weight-bold text-body">${tradeUnit.getValue().getPrice() * tradeUnit.getValue().getQuantity()} </div>
                </td>
                <td>
                    <form>
                    <div class="btn-toolbar">
                        <div class="btn-group">
                            <button formaction="/changeorder?productId=${tradeUnit.getKey()}&act=1"
                                    formmethod="post" type="submit" class="btn btn-primary">+</button>
                            <button formaction="/changeorder?productId=${tradeUnit.getKey()}&act=-1"
                                    formmethod="post" type="submit" class="btn btn-warning">-</button>
                            <button formaction="/changeorder?productId=${tradeUnit.getKey()}&act=0"
                                    formmethod="post" type="submit" class="btn btn-danger">x</button>
                        </div>
                    </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <td></td>
        <td></td>
        <td><div class="font-weight-bold text-info">ИТОГО:</div></td>
        <td>
            <div class="font-weight-bold text-body">${sessionScope.cart.getTotal()} </div>
        </td>
        </tfoot>
    </table>
    <form action="/createorder" method="post">
        <input type="submit" class="btn btn-info" value="Оформить">
        <input formaction="index.jsp" type="submit" class="btn btn-info" value="Отмена">
    </form>

</div>
</body>
</html>

