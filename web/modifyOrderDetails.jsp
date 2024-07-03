<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>订单状态变更页面</title>
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
</head>
<body>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    订单状态变更页面</h2>
<table id="table">
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
        <td>
            <form id="statusForm" action="OrderController" method="Get">
            <label>
                <input name="action" value="change" style="display: none">
                <input name="oId" value="${sessionScope.reservation.oId}" style="display: none">
            <select name="status" id="all_statues"></select>
            </label>
            <script>
            // 假设这是从服务器端获取的数据
            var statuses = [
                '${sessionScope.reservation.oStatus}',
                '已撤销','已完成'
            ];

            // 获取select元素
            var select = document.getElementById('all_statues');

            // 动态生成option并添加到select中
            statuses.forEach(function(status) {
                var option = document.createElement('option');
                option.value = status;
                option.textContent = status;
                select.appendChild(option);
            });
            </script>
            </form>
        </td>
    </tr>
    <tr>
        <td style="height: 30px;border-style: none"><a href="OrderController?action=show&oId=${sessionScope.reservation.oId}">取消变更</a></td>
        <td style="height: 30px;border-style: none"><a href="#" onclick="document.getElementById('statusForm').submit()">确认变更</a></td>
    </tr>

</table>
</body>
</html>



