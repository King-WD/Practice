<%--
  Created by IntelliJ IDEA.
  User: 31494
  Date: 2024/7/20
  Time: 下午2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
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
            background-color: rgba(255,250,250,0.1);
            width:50%;
            position:relative;
            top:8%;
            left:24%;
        }
        label{
            display:inline-block;
            margin-top:3%;
            margin-bottom: 5%;
        }
    </style>
</head>
<body>
    <div class="content">
        <form action="StudentController" method="get">
            <label><span style="font-weight: 700">学号:</span>
                <input name="学号" type="text" value="${sessionScope.SInfo.getS_num()}">
            </label><br>
            <label><span style="font-weight: 700">姓名:</span>
                <input name="姓名" type="text" value="${sessionScope.SInfo.getS_name()}">
            </label><br>
            <label><span style="font-weight: 700">性别:</span>
                <input name="性别" type="text" value="${sessionScope.SInfo.getS_gender()}">
            </label><br>
            <label><span style="font-weight: 700">年龄:</span>
                <input name="年龄" type="text" value="${sessionScope.SInfo.getS_age()}">
            </label><br>
            <label><span style="font-weight: 700">生源地:</span>
                <input name="生源地" type="text" value="${sessionScope.SInfo.getS_addr()}">
            </label><br>
            <label><span style="font-weight: 700">所修学分:</span>
                <input name="所修学分" type="text" value="${sessionScope.SInfo.getS_credits()}">
            </label><br>
            <label><span style="font-weight: 700">班级:</span>
                <input name="班级" type="text" value="${sessionScope.SInfo.getS_C_num()}">
            </label><br>
            <label>
                <input type="button" value="返回" onclick="window.location.href='Student.jsp'"
                style="width:55px;height:40px;">
            </label>
        </form>
    </div>
</body>
</html>
