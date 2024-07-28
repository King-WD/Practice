<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>成绩查询</title>
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
        #semester{
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
    <form action="StudentController?action=Grade_Query" method="get">
        <input type="hidden" name="action" value="Grade_Query">
        <span style="font-size:30px;font-weight: 700;vertical-align: center">学期:</span>
        <label>
          <select name="semester" id="semester">
              <option value="大一上"
                      <c:if test="${sessionScope.Course_semester eq '大一上'}">selected</c:if>>
                      大一上</option>
              <option value="大一下"
                      <c:if test="${sessionScope.Course_semester eq '大一下'}">selected</c:if>>
                  大一下</option>
              <option value="大二上"
                      <c:if test="${sessionScope.Course_semester eq '大二上'}">selected</c:if>>
                  大二上</option>
              <option value="大二下"
                      <c:if test="${sessionScope.Course_semester eq '大二下'}">selected</c:if>>
                  大二下</option>
          </select>
        </label>
      <c:choose>
          <c:when test="${empty sessionScope.Reports}">
              <br><span style="font-size:40px;font-weight: 700;
              display:inline-block;margin-top:5%;">请选择学期</span>
          </c:when>
          <c:otherwise>
              <table>
                  <tr>
                      <td><span style="font-weight: 700">课程编号</span></td>
                      <td><span style="font-weight: 700">学号</span></td>
                      <td><span style="font-weight: 700">成绩</span></td>
                      <td><span style="font-weight: 700">学期</span></td>
                      <td><span style="font-weight: 700">教师姓名</span></td>
                  </tr>
                  <c:forEach var="report" items="${sessionScope.Reports}">
                      <tr>
                          <td>${report.getCourse_num()}</td>
                          <td>${report.getS_num()}</td>
                          <td>${report.getGrade()}</td>
                          <td>${report.getCourse_semester()}</td>
                          <td>${report.getT_name()}</td>
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
