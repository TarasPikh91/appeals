<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: taras.pikh
  Date: 11.11.2021
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div c:if="${param.error}">
        Invalid username and password.
    </div>
    <div c:if="${param.logout}">
        You have been logged out.
    </div>
    <form c:action="@{/login}" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
    </form>

    <div>
        <a href="@{/signUp}">Sign Up</a>
    </div>
</body>
</html>
