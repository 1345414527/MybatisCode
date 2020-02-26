<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/10/5
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
  起飞机场:
  <select>
      <option>请选择</option>
      <c:forEach items="${requestScope.takeport}" var="take">
          <option value="${take.id}">${take.portname}</option>
      </c:forEach>

  </select>
</body>
</html>
