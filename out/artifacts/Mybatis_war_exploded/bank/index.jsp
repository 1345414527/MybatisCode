<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/9/26
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
  <form action="/Mybatis/ServletTransferServlet">
     转账账户:<input  type="text" name="accOutAccNo"/><br/>
     密码:<input  type="password" name="accOutPassward"/><br/>
     金额:<input  type="text" name="accOutBalance"/><br/>
     收款账户<input  type="text" name="accInAccNo"/><br/>
     收款姓名<input  type="text" name="accInName"/><br/>
      <input type="submit" value="转账"/><br/>

  </form>
</body>
</html>
