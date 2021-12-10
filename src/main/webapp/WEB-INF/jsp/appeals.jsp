<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: taras.pikh
  Date: 07.12.2021
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Appeals</title>
    <link href="css/main.css" rel="stylesheet"/>

</head>
<body>
<jsp:include page="templates/_header.jsp"/>
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
</body>
</html>
