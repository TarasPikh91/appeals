<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
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
    <title>Log In test</title>
</head>
<body>
    <div c:if="${param.error}">
        <spring:message code="message.invalid_data.message"/>
    </div>
    <div c:if="${param.logout}">
        <spring:message code="message.success_log_in.message"/>
    </div>
    <form c:action="@{/login}" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div><label><spring:message code="message.user_name.label"/><input type="text" name="username"/> </label></div>
        <div><label><spring:message code="message.password.label"/><input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
    </form>

    <div>
        <a href="registration/signUp"><spring:message code="message.sign_up.label"/></a>
    </div>
</body>
</html>
