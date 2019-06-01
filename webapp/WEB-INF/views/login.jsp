<%--
  Created by IntelliJ IDEA.
  User: mike
  Date: 30/05/19
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Borisov.ru</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>

<form:form method="post" commandName="user" action="check-user" class="login">
    <p>
        <form:label path="name">Логин:</form:label>
        <form:input path="name"/>
    </p>

    <p>
        <form:label path="password">Пароль:</form:label>
        <form:password path="password"/>
    </p>

    <p>
        <form:label path="admin" > Админ </form:label>
        <form:checkbox path="admin"/>


    </p>


    <p class="login-submit">
        <button type="submit" class="login-button">Войти</button>
    </p>


    <p class="forgot-password"><a href="login.jsp">Забыл пароль?</a></p>
</form:form>
</body>
</html>
