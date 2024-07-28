<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改结果</title>
    <style>
        body{
            background-image: url("picture/寂静时光平板风景2732_2048壁纸_彼岸图网.jpg");
            background-size: cover;
        }
        h2{
            width:500px;
            position: relative;
            top:360px;
            left:620px;
        }
    </style>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.Result=='原密码错误或为空!请重新输入'}">
        <h2>原密码错误或为空!请重新输入 页面将在5秒后跳转...</h2>
        <script type="text/javascript">
        // 在页面加载完成后执行
        window.onload = function() {
            setTimeout(function() {
                window.location.href = "/173_Homework_war_exploded/SChange.jsp";
            }, 5000);
        };
    </script>
    </c:when>
    <c:when test="${sessionScope.Result=='两次密码不相等!请重新输入'}">
        <h2>两次密码不相等!请重新输入 页面将在5秒后跳转...</h2>
        <script type="text/javascript">
            // 在页面加载完成后执行
            window.onload = function() {
                setTimeout(function() {
                    window.location.href = "/173_Homework_war_exploded/SChange.jsp";
                }, 5000);
            };
        </script>
    </c:when>
    <c:otherwise>
        <h2>密码修改成功！页面将在5秒后跳转...</h2>
        <script type="text/javascript">
            // 在页面加载完成后执行
            window.onload = function() {
                setTimeout(function() {
                    window.location.href = "/173_Homework_war_exploded/Student.jsp";
                }, 5000);
            };
        </script>
    </c:otherwise>
</c:choose>
</body>
</html>
