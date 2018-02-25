<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4>
    Dane dla
    <c:out value="${sessionScope.data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${sessionScope.code}"/>
</h4>

<c:choose>
    <c:when test="${dateLogicError != null}">
        <h5 style="color: red;">${dateLogicError}</h5>
    </c:when>
    <c:otherwise>
        <h5>
            z okresu <c:out value="${startDate}"/> - <c:out value="${endDate}"/>
        </h5>
        <c:choose>
            <c:when test="${sessionScope.toConversion==true}">
                <h5 style="color: red;">Dane uproszczone za pomocą ${sessionScope.conversion}</h5>
            </c:when>
            <c:otherwise>
                <h5>
                    Dane nieuproszczone.
                </h5>
            </c:otherwise>
        </c:choose>


        <jsp:include page="table-with-rawdata.jsp"/>
    </c:otherwise>
</c:choose>



