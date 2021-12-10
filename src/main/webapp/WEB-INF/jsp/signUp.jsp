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
    <title>Sign Up</title>
</head>
<body>
<div>
    <form method="post">
        <span>Full Username:</span>
        <input type="text" name="fullUsername">

        <span>Username:</span>
        <input type="text" name="username">

        <span>Email:</span>
        <input type="email" name="email">

        <span>Password:</span>
        <input type="password" name="password">

        <span>Phone:</span>
        <input type="text" name="phone">

        <input type="submit" value="Sign Up">
    </form>
</div>
</body>
</html>
