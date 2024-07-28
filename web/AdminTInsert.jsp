<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>教师管理</title>
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
        <br><span style="font-size:40px;font-weight: 700;
              display:inline-block;margin-top:5%;" id="tip">请点击添加</span><br>
        <table id="myTable"></table>
        <input style="display:inline-block;text-align:center;margin-top:5%;width:8%;height:4%;"
               type="button" onclick="addRow()" value="添加">
        <input style="display:inline-block;text-align:center;margin-top:5%;width:8%;height:4%;"
               type="button" onclick="submitForm('Teacher_Add')" value="确认">
        <input  style="display:inline-block;text-align:center;margin-top:5%;margin-left:50px;width:8%;height:4%;"
                type="button" value="取消" onclick="goBack()">
    </form>
</div>
<script>
    function submitForm(action) {
        document.getElementById('formAction').value = action;
        document.getElementById('myForm').submit();
    }
    function goBack(){
        window.history.back();
    }
    function addRow(){
        document.getElementById("tip").style.display="none";
        let table = document.getElementById("myTable");
        let row1 = table.insertRow(-1);
        let cell11 = row1.insertCell(0);
        cell11.innerHTML = '教师编号';
        let cell12 = row1.insertCell(1);
        cell12.innerHTML='<label><input type="text" name="selects" value=""></label></td>';
        let row2 = table.insertRow(-1);
        let cell21 = row2.insertCell(0);
        cell21.innerHTML = '教师姓名';
        let cell22 = row2.insertCell(1);
        cell22.innerHTML='<label><input type="text" name="selects" value=""></label></td>';
        let row3 = table.insertRow(-1);
        let cell31 = row3.insertCell(0);
        cell31.innerHTML = '性别';
        let cell32 = row3.insertCell(1);
        cell32.innerHTML='<label><input type="text" name="selects" value=""></label></td>';
        let row4 = table.insertRow(-1);
        let cell41 = row4.insertCell(0);
        cell41.innerHTML = '年龄';
        let cell42 = row4.insertCell(1);
        cell42.innerHTML='<label><input type="text" name="selects" value=""></label></td>';
        let row5 = table.insertRow(-1);
        let cell51 = row5.insertCell(0);
        cell51.innerHTML = '职称';
        let cell52 = row5.insertCell(1);
        cell52.innerHTML='<label><input type="text" name="selects" value=""></label></td>';
        let row6 = table.insertRow(-1);
        let cell61 = row6.insertCell(0);
        cell61.innerHTML = '联系电话';
        let cell62 = row6.insertCell(1);
        cell62.innerHTML='<label><input type="text" name="selects" value=""></label></td>';
    }
</script>
</body>
</html>





