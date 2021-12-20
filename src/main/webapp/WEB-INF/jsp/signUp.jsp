<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form method="POST" form:action="@{registration/signUp}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div>
            <span><spring:message code="message.full_username.label"/></span>
            <input type="text" name="fullUsername">
        </div>
        <div>
            <span><spring:message code="message.user_name.label"/></span>
            <input type="text" name="username">
        </div>
        <div>
            <span><spring:message code="message.email.label"/></span>
            <input type="email" name="email">
        </div>
        <div>
            <span><spring:message code="message.password.label"/></span>
            <input type="password" name="password">
        </div>
        <div>
            <span><spring:message code="message.phone.label"/></span>
            <input type="text" name="phone">
        </div>

        <input type="submit" value="${signup}">
    </form>
</div>
</body>
</html>
