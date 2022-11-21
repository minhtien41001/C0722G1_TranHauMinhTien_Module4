<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 21/11/2022
  Time: 2:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Từ điển</title>
  </head>
  <body>
  <form action="/dictionary" method="get">
    <input type="text" name="eng" placeholder="Input"> <br> <br>
    <button type="submit">Search</button> <br>
    <h3>${result}</h3>
  </form>
  </body>
</html>
