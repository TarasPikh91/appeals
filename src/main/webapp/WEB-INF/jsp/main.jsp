<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <link href="css/main.css" type="text/css" rel="stylesheet"/>
    <title>Main page</title>
</head>
<body>
<jsp:include page="templates/_header.jsp"/>

<div class="appeals-block">
    <table>
        <thead>
        <tr>
            <td><spring:message code="message.date_created.label"/></td>
            <td><spring:message code="message.appeal_text.label"/></td>
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