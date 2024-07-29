<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>教师页面</title>
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
            <td style="background-color:#3EEDC8;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#3EEDC8'">
                <a href="TeacherController?action=Info_Query&T_num=${sessionScope.T_num}">个人信息查询</a>
            </td>
            <td style="background-color:#3ED9ED;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#3ED9ED'">
                <a href="TeacherController?action=Average_Course&T_num=${sessionScope.T_num}">平均成绩</a></td>
            <td style="background-color:#3EA1ED;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#3EA1ED'">
                <a href="TeacherController?action=Submit&T_num=${sessionScope.T_num}">提交成绩</a></td>
        </tr>
        <tr>
            <td style="background-color:#3EEDC8;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#3EEDC8'">
                <a href="TeacherController?action=Teacher_Course&T_num=${sessionScope.T_num}">任课查询</a>
            </td>
            <td style="background-color:#71C3F0;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#71C3F0'">
                <a href="TeacherController?action=Sort&T_num=${sessionScope.T_num}">课程排名</a></td>
            <td style="background-color:#96EAF4;"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#96EAF4'">
                <a href="TeacherController?action=Password&T_num=${sessionScope.T_num}">修改密码</a></td>
        </tr>
        <tr>
            <td style="background-color:#96EAF4;height: 100px"
                onmouseover="this.style.backgroundColor='rgb(240,240,245)'"
                onmouseout="this.style.backgroundColor='#cafcf7'">
                <a href="TeacherController?action=Exit">退出</a></td>
        </tr>
    </table>
</div>
</body>
</html>

