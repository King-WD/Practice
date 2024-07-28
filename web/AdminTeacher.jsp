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
        #num{
            display: inline-block;
            width:200px;
            height:60px;
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
        <span style="font-size:30px;font-weight: 700;vertical-align: center">编号查询:</span>
        <label>
            <input type="text" name="num" id="num" value="${requestScope.T_num}">
        </label>
        <c:choose>
            <c:when test="${empty sessionScope.Teacher}">
                <br><span style="font-size:40px;font-weight: 700;
              display:inline-block;margin-top:5%;">请输入编号</span>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <td><span style="font-weight: 700">教师编号</span></td>
                        <td><label><input type="text" name="selects" value="${sessionScope.Teacher.getT_num()}"></label></td>
                    <tr>
                        <td><span style="font-weight: 700">教师姓名</span></td>
                        <td><label><input type="text" name="selects" value="${sessionScope.Teacher.getT_name()}"></label></td>
                    </tr>
                    <tr>
                        <td><span style="font-weight: 700">性别</span></td>
                        <td><label><input type="text" name="selects" value="${sessionScope.Teacher.getT_gender()}"></label></td>
                    </tr>
                    <tr>
                        <td><span style="font-weight: 700">年龄</span></td>
                        <td><label><input type="text" name="selects" value="${sessionScope.Teacher.getT_age()}"></label></td>
                    </tr>
                    <tr>
                        <td><span style="font-weight: 700">职称</span></td>
                        <td><label><input type="text" name="selects" value="${sessionScope.Teacher.getT_title()}"></label></td>
                    </tr>
                    <tr>
                        <td><span style="font-weight: 700">联系方式</span></td>
                        <td><label><input type="text" name="selects" value="${sessionScope.Teacher.getT_tele()}"></label></td>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
        <br>
        <input style="display:inline-block;text-align:center;margin-top:5%;width:8%;height:4%;"
               type="button" onclick="submitForm('Teacher_Query')" value="查询">
        <input style="display:inline-block;text-align:center;margin-top:5%;width:8%;height:4%;"
               type="button" onclick="submitForm('Teacher_Insert')" value="插入">
        <input style="display:inline-block;text-align:center;margin-top:5%;width:8%;height:4%;"
               type="button" onclick="submitForm('Teacher_Delete')" value="删除">
        <input style="display:inline-block;text-align:center;margin-top:5%;width:8%;height:4%;"
               type="button" onclick="submitForm('Teacher_Save')" value="保存">
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




