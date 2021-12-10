<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Main page</title>
</head>
<body>
<div>
    <div><a href="/">Home</a></div>
    <div><a href="create_appeal">Create New Appeal</a></div>
    <div>My Appeals</div>
    <div>Sign Up</div>
</div>
<div>
    <c:forEach var="appeal" items="${appeals}">
        <div>${appeal}</div>
    </c:forEach>
</div>
</body>
</html>