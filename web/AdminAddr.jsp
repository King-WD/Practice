<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>生源地统计</title>
    <style>
        body{
            background-image:url("picture/炫酷特效视觉艺术设计星空光宇宙高清壁纸_图片编号2703_壁纸网.jpeg");
            background-size:cover;
            margin:0;
            padding:0;
            width:100vw;
            height:100vh;
        }
        .content{
            width:100%;
            height:100%;
        }
        form{
            text-align: center;
            width:50%;
            position:relative;
            top:30%;
            left:26%;
        }
        #addr{
            display: inline-block;
            width:200px;
            height:60px;
            text-align: center;
            font-size: 25px
        }
        table{
            text-align: center;
            width:50%;
            position:relative;
            margin-top:7%;
            left:26%;
        }
    </style>
</head>
<body>
<div class="content">
    <form id="myForm" action="AdminController" method="get">
        <input type="hidden" name="action" id="formAction" value="">
        <span style="font-size:30px;font-weight: 700;vertical-align: center">生源地选择:</span>
        <label>
            <input type="text" name="addr" id="addr" value="${requestScope.S_addr}">
        </label>
        <c:choose>
            <c:when test="${empty sessionScope.Total}">
                <br><span style="font-size:40px;font-weight: 700;
              display:inline-block;margin-top:5%;">请输入生源地</span>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <td><span style="font-weight: 700">生源地</span></td>
                        <td><span style="font-weight: 700">总数</span></td>
                    </tr>
                    <tr>
                    <c:forEach var="total" items="${sessionScope.Total}">
                        <td><label><input type="text" value="${total}" style="text-align: center"></label></td>
                    </c:forEach>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
        <br>
        <input style="display:inline-block;text-align:center;margin-top:5%;width:8%;height:4%;"
               type="button" onclick="submitForm('Addr_Query')" value="查询">
        <input  style="display:inline-block;text-align:center;margin-top:5%;margin-left:50px;width:8%;height:4%;"
                type="button" value="返回" onclick="window.location.href='Admin.jsp'">
    </form>
</div>
<script>
    function submitForm(action) {
        document.getElementById('formAction').value = action;
        document.getElementById('myForm').submit();
    }
</script>
</body>
</html>






