<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/9/26
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>log.jsp</title>
</head>
<body>
  <table>
      <tr>
          <th>转账账号</th>
          <th>收款账号</th>
          <th>转账金额</th>
      </tr>

      <c:forEach var="log" items="${requestScope.pageInfo.list}">
           <tr>
               <th>${log.accOut}</th>
               <th>${log.accIn}</th>
               <th>${log.money}</th>
           </tr>
      </c:forEach>

      <a href="/Mybatis/ShowServlet?pageNumber=${pageInfo.pageNumber-1}&&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNumber<=1}"> onclick="javascript:return false;" </c:if>上一页</a>
      <a href="/Mybatis/ShowServlet?pageNumber=${pageInfo.pageNumber-1}&&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNumber>=pageInfo.total}"> onclick="javascript:return false;" </c:if>下一页</a>

  </table>
</body>
</html>
