<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="header-block">
    <div><a href="/"><spring:message code="message.home.label"/></a></div>
    <div><a href="create_appeal"><spring:message code="message.create_appeal.label"/></a></div>
    <div><a href="appeals"><spring:message code="message.my_appeals.label"/></a></div>
    <c:if test="${sessionScope.get('userLoggedIn') == null}">
        <div><a href="signup"><spring:message code="message.sign_up.label"/></a></div>
    </c:if>
</div>
