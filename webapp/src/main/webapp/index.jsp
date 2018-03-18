<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${sessionScope.language == null}">
    <c:set var="language" scope="session" value="en_GB"/>
</c:if>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>
<html lang="${language}">
<head>
    <meta charset="UTF-8"/>
    <title><fmt:message key="home.appName" bundle="${finAppLanguage}"/></title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="float-right">
    <jsp:include page="portal/general/language-flags.jsp"/>
</div>
<div class="container-fluid">
    <div class="row">
        <content class="col col-sm-12 col-lg-8 offset-lg-2">
            <div class="main jumbotron vertical-center">
                <h1 class="display-3"><fmt:message key="home.appName" bundle="${finAppLanguage}"/></h1>
                <p class="lead"><fmt:message key="home.loginInfo" bundle="${finAppLanguage}"/></p>
                <p><fmt:message key="home.loginPressButtonInfo" bundle="${finAppLanguage}"/></p>
                <p class="lead">
                    <a class="btn btn-primary btn-lg" href="/portal/home" role="button"><fmt:message key="home.login" bundle="${finAppLanguage}"/></a>
                </p>
            </div>
        </content>
    </div>
</div>

<script src="js/jquery-3.2.1.slim.min.js"></script>
<script src="js/popper.min.js"></script>
</body>
</html>