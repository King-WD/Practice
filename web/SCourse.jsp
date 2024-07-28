<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
  <title>课表查询</title>
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
    .content_course{
      text-align: center;
      width:50%;
      position:relative;
      top:27%;
      left:26%;
    }
    .credits{
      display: inline-block;
      width:190px;
      height:50px;
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
  <div class="content_course">
    <span style="font-size:30px;font-weight: 700;vertical-align: center">总学分:</span>
    <c:set var="credit_sum" value="0"/>
    <c:forEach var="Course_Credit" items="${sessionScope.Course_Credits}">
       <c:set var="credit_sum" value="${credit_sum+Course_Credit.getCourse_credit()}"/>
    </c:forEach>
    <label><input class="credits" type="text" value="${credit_sum}"></label>
    <table>
      <tr>
        <td>
          <span style="font-size:20px;font-weight: 700;vertical-align: center">学号</span>
        </td>
        <td>
          <span style="font-size:20px;font-weight: 700;vertical-align: center">课程名称</span>
        </td>
        <td>
          <span style="font-size:20px;font-weight: 700;vertical-align: center">课程学分</span>
        </td>
      </tr>
          <c:forEach var="Course_Credit" items="${sessionScope.Course_Credits}">
            <tr>
              <td>${Course_Credit.getS_num()}</td>
              <td>${Course_Credit.getCourse_name()}</td>
              <td>${Course_Credit.getCourse_credit()}</td>
            </tr>
          </c:forEach>
    </table>
    <br>
    <input  style="display:inline-block;text-align:center;margin-top:5%;margin-left:50px;width:8%;height:4%;"
            type="button" value="返回" onclick="window.location.href='Student.jsp'">
  </>
</div>
</body>
</html>


