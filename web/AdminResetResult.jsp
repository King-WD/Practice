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
    <c:when test="${sessionScope.Result=='不存在此人'}">
        <h2>不存在此人! 页面将在5秒后跳转...</h2>
        <script type="text/javascript">
            // 在页面加载完成后执行
            window.onload = function() {
                setTimeout(function() {
                    window.location.href = "/173_Homework_war_exploded/AdminReset.jsp";
                }, 5000);
            };
        </script>
     </c:when>
     <c:otherwise>
         <h2>重置成功 页面将在5秒后跳转...</h2>
         <script type="text/javascript">
             // 在页面加载完成后执行
             window.onload = function() {
                 setTimeout(function() {
                     window.location.href = "/173_Homework_war_exploded/Admin.jsp";
                 }, 5000);
             };
         </script>
     </c:otherwise>
</c:choose>
</body>
</html>



