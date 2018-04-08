<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 13.11.16
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <h1>Hi, ${name}</h1>
    <form>
        <input type="button" value="Выйти" onclick=location.href="/logout">
    </form>
    <form>
        <input type="button" value="Секрет" onclick=location.href="/secret">
    </form>
</body>
</html>
