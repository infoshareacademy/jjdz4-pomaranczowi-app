<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.language == null}">
    <c:set var="language" scope="session" value="en_GB"/>
</c:if>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/homepage"><fmt:message key="home.appName" bundle="${finAppLanguage}"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/homepage"><fmt:message key="home.homePage" bundle="${finAppLanguage}"/> <span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/report"><fmt:message key="home.report" bundle="${finAppLanguage}"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/portal/upload"><fmt:message key="home.upload" bundle="${finAppLanguage}"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout"><fmt:message key="home.logout" bundle="${finAppLanguage}"/></a>
            </li>
        </ul>
    </div>
    <jsp:include page="language-flags.jsp"/>
</nav>