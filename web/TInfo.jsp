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
            top:11%;
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
        <label><span style="font-weight: 700">教师编号:</span>
            <input name="教师编号" type="text" value="${sessionScope.TInfo.getT_num()}">
        </label><br>
        <label><span style="font-weight: 700">教师姓名:</span>
            <input name="教师姓名" type="text" value="${sessionScope.TInfo.getT_name()}">
        </label><br>
        <label><span style="font-weight: 700">教师性别:</span>
            <input name="教师性别" type="text" value="${sessionScope.TInfo.getT_gender()}">
        </label><br>
        <label><span style="font-weight: 700">教师年龄:</span>
            <input name="教师年龄" type="text" value="${sessionScope.TInfo.getT_age()}">
        </label><br>
        <label><span style="font-weight: 700">教师职称:</span>
            <input name="教师职称" type="text" value="${sessionScope.TInfo.getT_title()}">
        </label><br>
        <label><span style="font-weight: 700">联系方式:</span>
            <input name="联系方式" type="text" value="${sessionScope.TInfo.getT_tele()}">
        </label><br>
        <label>
            <input type="button" value="返回" onclick="window.location.href='Teacher.jsp'"
                   style="width:55px;height:40px;">
        </label>
    </form>
</div>
</body>
</html>

