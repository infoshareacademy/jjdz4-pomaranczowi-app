<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 11.03.18
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<h4>
    <fmt:message key="${globalExtremesMessage}" bundle="${finAppLanguage}"/>
    <c:out value="Report"/>
</h4>


<jsp:include page="../report/qotation_table_from_report_module.jsp"/>