<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form th:action="/update" method="post">
    <div><label>Id: <input type="text" name="id"/> </label></div>
    <div><label>New Price: <input type="text" name="price"/> </label></div>
    <div><input type="submit" value="Submit"/></div>
</form>
</body>
</html>
