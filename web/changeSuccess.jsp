<%--
  Created by IntelliJ IDEA.
  User: 魏栋
  Date: 2024/6/16
  Time: 下午5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>变更成功</title>
    <script type="text/javascript">
        // 在页面加载完成后执行
        window.onload = function() {
            // 设置5秒后跳转到allOrder.jsp页面
            setTimeout(function() {
                window.location.href = "/173_Homework_war_exploded/OrderController?action=show&oId=${sessionScope.reservation.oId}";
            }, 5000);
        };
    </script>
</head>
<body>

<h2>变更成功！页面将在5秒后跳转...</h2>

</body>
</html>
