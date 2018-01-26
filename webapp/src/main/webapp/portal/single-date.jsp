<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4>
    Notowania z dnia <c:out value="${sessionScope.date}"/> dla
    <c:out value="${sessionScope.data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${sessionScope.code}."/>
</h4>