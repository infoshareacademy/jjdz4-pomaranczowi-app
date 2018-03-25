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
<jsp:include page="../general/navbar.jsp"/>
<div class="container-fluid">
    <div class="row" style="height: auto;">
        <content class="col col-sm-12 col-lg-8 offset-lg-2">
            <div class="jumbotron content">
                <h4>
                    <fmt:message key="report.CurrencyMax" bundle="${finAppLanguage}"/>
                </h4>

                <jsp:include page="../report/currency_max_of_use.jsp"/>
            </div>
        </content>
        <content class="col col-sm-12 col-lg-8 offset-lg-2">
            <div class="jumbotron content">
                <h4>
                    <fmt:message key="report.InvestmentMax" bundle="${finAppLanguage}"/>
                </h4>

                <jsp:include page="../report/investments_max_of_use.jsp"/>
            </div>
        </content>
        <content class="col col-sm-12 col-lg-8 offset-lg-2">
            <div class="jumbotron content">
                <h4>
            <div class="jumbotron content padding-small">
                <h2><fmt:message key="report.Title" bundle="${finAppLanguage}"/></h2>
                <h3>
                    <fmt:message key="report.Currency" bundle="${finAppLanguage}"/>
                </h3>

                <jsp:include page="../report/currency_from_report_module.jsp"/>

                <h3>
                    <fmt:message key="report.Investment" bundle="${finAppLanguage}"/>
                </h3>

                <jsp:include page="../report/investments-from-report-module.jsp"/>
            </div>
        </content>
    </div>
</div>

<script src="js/jquery-3.2.1.slim.min.js"></script>
<script src="js/popper.min.js"></script>
</body>
</html>


