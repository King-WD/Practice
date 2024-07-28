<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录失败</title>
    <style>
        body{
            background-image: url("picture/寂静时光平板风景2732_2048壁纸_彼岸图网.jpg");
            background-size: cover;
        }
        h2{
            width:500px;
            position: relative;
            top:360px;
            left:640px;
        }
    </style>
</head>
<body>
<script type="text/javascript">
    // 在页面加载完成后执行
    window.onload = function() {
        // 设置5秒后跳转到allOrder.jsp页面
        setTimeout(function() {
            window.location.href = "/173_Homework_war_exploded/sign in.html";
        }, 5000);
    };
</script>
<c:choose>
    <c:when test="${sessionScope.excuse=='验证码错误'}">
       <h2>验证码错误！页面将在5秒后跳转...</h2>
    </c:when>
    <c:otherwise>
        <h2>用户名或密码错误！页面将在5秒后跳转...</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
