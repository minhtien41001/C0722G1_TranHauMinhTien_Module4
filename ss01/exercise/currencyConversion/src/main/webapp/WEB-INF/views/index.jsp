<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 21/11/2022
  Time: 1:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Chuyển đổi tiền tệ</title>
  </head>
  <body>
  <form action="/exchange" method="get">
    <input type="number" name="money" placeholder="Input USD"> (USD) <br><br>
    <button type="submit">Convert</button><br><br>
    <input type="text" value="${result}" disabled> (VNĐ)
  </form>
  </body>
</html>
