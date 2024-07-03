<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品预订系统之用户订单一览表</title>
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
    &nbsp;&nbsp;&nbsp;商品预订系统之用户订单一览表</h2>
<table id="table">
    <tr>
        <th>用户ID</th>
        <th>用户名</th>
        <th>商品订单</th>
    </tr>
    <c:forEach var="ur" items="${sessionScope.userReservations}">
        <tr>
            <td>${ur.user.userId}</td>
            <td>${ur.user.userName}</td>
            <td>
                <c:forEach var="res" items="${ur.reservations}" varStatus="status">
                    <a href='OrderController?oId=${res.oId}&action=show'>订单ID-${res.oId}</a>
                    <c:if test="${not status.last}">、</c:if>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

