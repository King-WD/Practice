<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生页面</title>
    <style>
        body{
            background-image:url("picture/炫酷特效视觉艺术设计星空光宇宙高清壁纸_图片编号2703_壁纸网.jpeg");
            background-size:cover;
            margin:0;
            padding:0;
            width:100vw;
            height:100vh;
        }
        #whole{
            width:100%;
            height:100%;
        }
        table{
            background-color:transparent;
            border-collapse:separate;
            border-spacing:10px;
            position:relative;
            top:20%;
            left:31%;
        }
        td{
            font-size:25px;
            text-align: center;
            background-color:white;
            border-style: solid;
            border-width: 1px;
            width:200px;
            height:200px;
        }
        td:hover{
            background-color:rgb(240,240,245);
        }
        a{
            color:black;
            text-decoration:none;
        }
        a:hover{
            color:firebrick;
            text-decoration:none;
        }
    </style>
</head>
<body>
<div id="whole">
<table id="table">
        <tr>
            <td rowspan="2" style="background-color:#3EEDC8;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#3EEDC8'">
                <a href="StudentController?action=Info_Query&S_num=${sessionScope.S_num}">个人信息查询</a>
            </td>
            <td style="background-color:#3ED9ED;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#3ED9ED'">
                <a href="StudentController?action=Grade&S_num=${sessionScope.S_num}">成绩查询</a></td>
            <td style="background-color:#3EA1ED;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#3EA1ED'">
                <a href="StudentController?action=Course_Credit_Query&S_num=${sessionScope.S_num}">课程查询</a></td>

        </tr>
        <tr>
            <td style="background-color:#71C3F0;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#71C3F0'">
                <a href="StudentController?action=Class_Course_Query&S_num=${sessionScope.S_num}">班级课表查询</a></td>
            <td style="background-color:#96EAF4;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#96EAF4'">
                <a href="StudentController?action=Password&S_num=${sessionScope.S_num}">修改密码</a></td>
        </tr>
        <tr>
            <td style="background-color:#96EAF4;height: 100px"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#cafcf7'">
                <a href="StudentController?action=Exit">退出</a></td>
        </tr>
</table>
</div>
</body>
</html>

