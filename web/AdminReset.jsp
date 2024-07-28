<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>重置密码</title>
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
        #identity{
            display: inline-block;
            width:200px;
            height:60px;
            text-align: center;
            font-size: 25px
        }
        input{
            display: inline-block;
            width:180px;
            height:40px;
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
        <span style="font-size:30px;font-weight: 700;vertical-align: center">身份选择:</span>
        <label>
            <select name="identity" id="identity">
                <option value="教师">教师</option>
                <option value="学生">学生</option>
            </select>
        </label>
                <table>
                    <tr>
                        <td><span style="font-size:20px;font-weight: 700">账号:</span></td>
                        <td><label><input type="text" name="account" value=""></label></td>
                    </tr>
                    <tr>
                        <td><span style="font-size:20px;font-weight: 700">重置密码:</span></td>
                        <td><label><input type="text" name="reset" value=""></label></td>
                    </tr>
                </table>
        <br>
        <input style="display:inline-block;text-align:center;margin-top:5%;width:8%;height:4%;"
               type="button" onclick="submitForm('Sure_Reset')" value="确认">
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




