<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/9/25
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
   <table border="1px">
       <th>编号</th>
       <th>姓名</th>
       <th>年龄</th>

       <c:forEach var="pageInfo" items="${requestScope.pageInfo.list}">
       <tr>${pageInfo.id}</tr>
       <tr>${pageInfo.name}</tr>
       <tr>${pageInfo.age}</tr>
   </c:forEach>

       <a href="/Mybatis/ShowPageServlet?pageNumber=${requestScope.pageInfo.pageNumber-1}&pagesize=${requestScope.pageInfo.pageSize}" <c:if test="${requestScope.pageInfo.pageNumber<=1}"> onclick="javascript:return false;"</c:if>>上一页</a>
       <a href="/Mybatis/ShowPageServlet?pageNumber=${requestScope.pageInfo.pageNumber+1}&pagesize=${requestScope.pageInfo.pageSize}" <c:if test="${requestScope.pageInfo.pageNumber>=pageInfo.total}"> onclick="javascript:return false;"</c:if>>下一页</a>


   </table>
</body>
</html>
