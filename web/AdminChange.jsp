<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
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
            top:18%;
            left:25%;
        }
        label{
            display: inline-block;
            margin-top:5%;
            margin-bottom: 5%;
        }
    </style>
</head>
<body>
<div class="content">
    <form action="AdminController?" method="get">
        <input type="hidden" name="action" value="Change_Password">
        <label><span style="font-size:25px;font-weight: 700;vertical-align: center">旧密码:</span>
            <input style="font-size:18px;width:250px;height:42px;"
                   name="Old" type="text">
        </label><br>
        <label><span style="font-size:25px;font-weight: 700;vertical-align: center">新密码:</span>
            <input style="font-size:15px;width:250px;height:42px;"
                   name="New" type="text">
        </label><br>
        <label><span style="font-size:25px;font-weight: 700;vertical-align: center">确认密码:</span>
            <input style="font-size:15px;width:250px;height:42px;"
                   name="Sure" type="text">
        </label><br>
        <input style="display:inline-block;text-align:center;margin-top:5%;margin-left:50px;width:10%;height:4%;"
               type="submit" value="确认修改">
        <input style="display:inline-block;text-align:center;margin-top:5%;margin-left:50px;width:10%;height:4%;"
               type="button" value="返回" onclick="window.location.href='Admin.jsp'">
    </form>
</div>
</body>
</html>

