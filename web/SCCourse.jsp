<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>班级课表查询</title>
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
            top:27%;
            left:26%;
        }
        #class{
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
    <form action="StudentController?action=Class_Course_Query" method="get">
        <input type="hidden" name="action" value="Class_Course_Query">
        <span style="font-size:30px;font-weight: 700;vertical-align: center">学期:</span>
        <label>
            <select name="class" id="class">
                <option value="计科1班"
                        <c:if test="${sessionScope.C_name eq '计科1班'}">selected</c:if>>
                    计科1班</option>
                <option value="计科2班"
                        <c:if test="${sessionScope.C_name eq '计科2班'}">selected</c:if>>
                    计科2班</option>
                <option value="软工1班"
                        <c:if test="${sessionScope.C_name eq '软工1班'}">selected</c:if>>
                    软工1班</option>
                <option value="软工2班"
                        <c:if test="${sessionScope.C_name eq '软工2班'}">selected</c:if>>
                    软工2班</option>
                <option value="智能1班"
                        <c:if test="${sessionScope.C_name eq '智能1班'}">selected</c:if>>
                    智能1班</option>
                <option value="智能2班"
                        <c:if test="${sessionScope.C_name eq '智能2班'}">selected</c:if>>
                    智能2班</option>
            </select>
        </label>
        <c:choose>
            <c:when test="${empty sessionScope.Class_Courses}">
                <br><span style="font-size:40px;font-weight: 700;
              display:inline-block;margin-top:5%;">请选择班级</span>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <td><span style="font-weight: 700">班级编号</span></td>
                        <td><span style="font-weight: 700">班级名称</span></td>
                        <td><span style="font-weight: 700">课程编号</span></td>
                        <td><span style="font-weight: 700">课程名称</span></td>
                        <td><span style="font-weight: 700">课程学期</span></td>
                        <td><span style="font-weight: 700">课程学分</span></td>
                        <td><span style="font-weight: 700">课程学时</span></td>
                    </tr>
                    <c:forEach var="Class_Course" items="${sessionScope.Class_Courses}">
                        <tr>
                            <td>${Class_Course.getC_num()}</td>
                            <td>${Class_Course.getC_name()}</td>
                            <td>${Class_Course.getCourse_num()}</td>
                            <td>${Class_Course.getCourse_name()}</td>
                            <td>${Class_Course.getCourse_semester()}</td>
                            <td>${Class_Course.getCourse_credit()}</td>
                            <td>${Class_Course.getCourse_time()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
        <br>
        <input style="display:inline-block;text-align:center;margin-top:5%;width:8%;height:4%;"
               type="submit" value="确认">
        <input  style="display:inline-block;text-align:center;margin-top:5%;margin-left:50px;width:8%;height:4%;"
                type="button" value="返回" onclick="window.location.href='Student.jsp'">
    </form>
</div>
</body>
</html>

