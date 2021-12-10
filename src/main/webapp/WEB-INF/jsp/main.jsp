<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
<%--    <link href="main.css" type="text/css" rel="stylesheet">--%>
    <link href="css/main.css" rel="stylesheet"/>
    <title>Main page</title>
</head>
<body>
<jsp:include page="templates/_header.jsp"/>

<div class="appeals-block">
    <table>
        <thead>
        <tr>
            <td>Date Created</td>
            <td>Appeal Data</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="appeal" items="${appeals}">
            <tr>
                <td>${appeal.appealDate}</td>
                <td>${appeal.appealText}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>