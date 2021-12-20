<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="header-block">
    <div><a href="/"><spring:message code="message.home.label"/></a></div>
    <div><a href="create_appeal"><spring:message code="message.create_appeal.label"/></a></div>
    <div><a href="appeals"><spring:message code="message.my_appeals.label"/></a></div>
    <div sec:authorize="isAuthenticated()">
        <div>
           <a href="${pageContext.request.contextPath}/logout?${_csrf.parameterName}=${_csrf.token}">
               <spring:message code="message.log_out.label"/>
           </a>
        </div>
    </div>
</div>
