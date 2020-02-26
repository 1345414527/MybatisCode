<%@ page import="com.bjsxt.pojo.People" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/9/24
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

<a href="/Mybatis/com/bjsxt/servlet/ShowServlet">查询</a>
  <table>
    <tr>
    <th>编号</th>
    <th>姓名</th>
    <th>年龄</th>
    </tr>

    <c:forEach var="peo" items="${requestScope.list}">
    <tr>
      <td>${peo.id}</td>
      <td>${peo.name}</td>
      <td>${peo.age}</td>
    </tr>
    </c:forEach>



  </table>

  </body>
</html>
