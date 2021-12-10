<%--
  Created by IntelliJ IDEA.
  User: taras.pikh
  Date: 10.11.2021
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Appeal</title>
    <link href="css/main.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="templates/_header.jsp"/>
<div>
    <div>Create New Appeal</div>
    <div>
        <form action="save_appeal" method="post">
            <textarea name="appealText" value=""></textarea>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Save Appeal"/>
        </form>
    </div>
</div>
</body>
</html>
