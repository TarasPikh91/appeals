<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <title><spring:message code="message.sign_up.label"/></title>
    <spring:message code="message.sign_up.label" var="signup"/>
</head>
<body>
<div>
    <form method="post">
        <span><spring:message code="message.full_username.label"/></span>
        <input type="text" name="fullUsername">

        <span><spring:message code="message.user_name.label"></span>
        <input type="text" name="username">

        <span><spring:message code="message.email.label"/></span>
        <input type="email" name="email">

        <span><spring:message code="message.password.label"/></span>
        <input type="password" name="password">

        <span><spring:message code="message.phone.label"/></span>
        <input type="text" name="phone">

        <input type="submit" value="${signup}">
    </form>
</div>
</body>
</html>
