<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>订单页面详情</title>
    <style>
        #table{
            border-collapse: collapse;
            border-spacing: 0;
            text-align: center;
            width: 500px;
            height: 300px;
        }
        th{
            border-style: solid;
        }
        td{
            border-style: solid;
        }
        a{
            color:black;
        }
    </style>
    <script>
        function changeOrder(orderStatus) {
            if (orderStatus === '进行中') {
                window.location.href = '/173_Homework_war_exploded/OrderController?action=prechange&oId=${sessionScope.reservation.oId}';
            } else {
                alert('无法变更');
            }
        }
    </script>
</head>
<body>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    订单页面详情</h2>
<table id="table">
    <tr>
    <td style="height: 30px;border-style: none"></td>
    <td style="height: 30px;border-style: none;text-align: right">
        <a href="#" onclick="changeOrder('${sessionScope.reservation.oStatus}')">变更订单</a></td>
    </tr>
    <tr>
        <td>用户ID</td>
        <td>${sessionScope.reservation.uId}</td>
    </tr>

    <tr>
        <td>订单ID</td>
        <td>${sessionScope.reservation.oId}</td>
    </tr>

    <tr>
        <td>订单时间</td>
        <td>${sessionScope.reservation.oTime}</td>
    </tr>

    <tr>
        <td>预定商品列表</td>
        <td>
            <c:forEach var="product" items="${sessionScope.products}" varStatus="loop">
                ${product.pName}(${product.pCount})
            </c:forEach>
        </td>
    </tr>

    <tr>
        <td>订单总价</td>
        <td>${sessionScope.reservation.oTotal}</td>
    </tr>

    <tr>
        <td>订单状态</td>
        <td>${sessionScope.reservation.oStatus}</td>
    </tr>

</table>
</body>
</html>


