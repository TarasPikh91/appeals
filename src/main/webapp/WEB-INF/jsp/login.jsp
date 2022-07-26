<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Log In test</title>
    <style>
        .login_main {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="login_main">
    <div c:if="${param.error}">
        <spring:message code="message.invalid_data.message"/>
    </div>
    <div c:if="${param.logout}">
        <spring:message code="message.success_log_in.message"/>
    </div>
    <div class="login_form_block">
        <form c:action="@{/login}" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div><label><spring:message code="message.email.label"/><input type="text" name="username"/> </label></div>
            <div><label><spring:message code="message.password.label"/><input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
        </form>
    </div>
    <div>
        <a href="registration/signUp"><spring:message code="message.sign_up.label"/></a>
    </div>
</div>
</body>
</html>
