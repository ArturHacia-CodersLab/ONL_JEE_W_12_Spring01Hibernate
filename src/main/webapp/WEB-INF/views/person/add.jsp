<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 10.07.2022
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="person">
    Login: <form:input path="login"/><br>
    Hasło: <form:password path="password"/><br>
    Email: <form:input path="email"/><br>
    <input type="submit" value="Wyślij"/>
</form:form>
</body>
</html>
