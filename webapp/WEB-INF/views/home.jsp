<%--
  Created by IntelliJ IDEA.
  User: mike
  Date: 30/05/19
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Borisov.ru</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>

<form method="post" action="" class="login">
    <p>
        <label for="login">Логин:</label>
        <input type="text" name="login" id="login" value="borisov.com">
    </p>

    <p>
        <label for="password">Пароль:</label>
        <input type="password" name="password" id="password" value="4815162342">
    </p>

    <p class="login-submit">
        <button type="submit" class="login-button">Войти</button>
    </p>

    <p class="forgot-password"><a href="home.jsp">Забыл пароль?</a></p>
</form>
</body>
</html>
